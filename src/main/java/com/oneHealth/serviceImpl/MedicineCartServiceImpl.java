package com.oneHealth.serviceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.oneHealth.dto.CartItemRequest;
import com.oneHealth.dto.MedicineStock;
import com.oneHealth.dto.Patient;
import com.oneHealth.entity.MedicineCart;
import com.oneHealth.entity.MedicineCartItem;
import com.oneHealth.exception.DatabaseException;
import com.oneHealth.exception.ResourceNotFoundException;
import com.oneHealth.exception.ServiceNotAvailableException;
import com.oneHealth.repository.MedicineCartRepository;
import com.oneHealth.service.MedicineCartService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MedicineCartServiceImpl implements MedicineCartService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicineCartServiceImpl.class);

    @Autowired
    private MedicineCartRepository medicineCartRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public void addToCart(CartItemRequest itemRequest) throws ResourceNotFoundException {
        LOGGER.info("Adding item to the cart: {}", itemRequest);

        // Fetch patient details from Patient Management service
        Patient patientDto = webClientBuilder.build()
                .get()
                .uri("https://onehealthpatientmanagement-yjb28-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/patientProfile/byPatientId/{patientId}", itemRequest.getPatientId())
                .retrieve()
                .bodyToMono(Patient.class)
                .block();

        if (patientDto == null) {
            LOGGER.error("Patient not found with Patient ID: {}", itemRequest.getPatientId());
            throw new ResourceNotFoundException("Patient Not found with Patient id: " + itemRequest.getPatientId());
        }

        // Fetching Medicine Details
        MedicineStock medicine = webClientBuilder.build()
                .get()
                .uri("https://apigateway-yjb28-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/InventoryManagement/medicineStock/byMedicineID/{medicineId}",
                        itemRequest.getMedicineId())
                .retrieve()
                .bodyToMono(MedicineStock.class)
                .block();
//      MedicineStock medicine = (medicineArray != null && medicineArray.length > 0) ? medicineArray[0] : null;

        if (medicine == null) {
            LOGGER.error("Medicine not found with Medicine ID: {}", itemRequest.getMedicineId());
            throw new ResourceNotFoundException("Medicine Not found with Medicine id: " + itemRequest.getMedicineId());
        }

        MedicineCartItem cartItem = new MedicineCartItem();
        cartItem.setQuantity(itemRequest.getQuantity());
        cartItem.setMedicineId(itemRequest.getMedicineId());
        cartItem.setPharmaName(medicine.getPharmaName());
        cartItem.setPharmaAddress(medicine.getPharmaAddress());
        cartItem.setPharmaId(medicine.getPharmaId());

        BigDecimal totalPrice = medicine.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
        cartItem.setTotalProductPrice(totalPrice);

        MedicineCart medicineCart = medicineCartRepository.findByPatientId(itemRequest.getPatientId());
        if (medicineCart == null) {
            medicineCart = new MedicineCart();
            medicineCart.setPatientId(itemRequest.getPatientId());
            medicineCart.setCartTotalPrice(totalPrice);
        } else {
            medicineCart.setCartTotalPrice(medicineCart.getCartTotalPrice().add(totalPrice));
        }
        cartItem.setMedicineCart(medicineCart);
        Set<MedicineCartItem> items = medicineCart.getMedicine_cart_items();
        AtomicReference<Boolean> flag = new AtomicReference<>(false);
        Set<MedicineCartItem> newitem = items.stream().map((i) -> {

            if (i.getMedicineId() == medicine.getMedicine().getMedicineId()) {

                int quantity = itemRequest.getQuantity() + i.getQuantity();
                i.setQuantity(quantity);
                BigDecimal total = medicine.getPrice().multiply(BigDecimal.valueOf(quantity));
                i.setTotalProductPrice(total);
                flag.set(true);
            }

            return i;
        }).collect(Collectors.toSet());

        if (flag.get()) {
            items.clear();
            items.addAll(newitem);

        } else {
            cartItem.setMedicineCart(medicineCart);
            items.add(cartItem);
        }

        cartItem.setMedicineName(medicine.getMedicine().getMedicineName());

        medicineCartRepository.save(medicineCart);
        LOGGER.info("Item added to the cart successfully.");
    }

    @Override
    public MedicineCart getCart(long patientId) throws ResourceNotFoundException, ServiceNotAvailableException {
        LOGGER.info("Fetching cart for Patient ID: {}", patientId);

        Patient patientDto = webClientBuilder.build()
                .get()
                .uri("https://onehealthpatientmanagement-yjb28-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/patientProfile/byPatientId/{patientId}", patientId)
                .retrieve()
                .bodyToMono(Patient.class)
                .block();

        if (patientDto == null) {
            LOGGER.error("Patient not found with Patient ID: {}", patientId);
            throw new ResourceNotFoundException("Patient not found with Patient ID: " + patientId);
        }

        MedicineCart cart = medicineCartRepository.findByPatientId(patientId);
        return cart;
    }

    @Override
    public void removeItem(long medicineId, long patientId) throws ResourceNotFoundException, ServiceNotAvailableException {
        LOGGER.info("Removing item from cart - Medicine ID: {}, Patient ID: {}", medicineId, patientId);

        MedicineCart medicineCart;
        try {
            medicineCart = this.mapper.map(getCart(patientId), MedicineCart.class);
        } catch (ResourceNotFoundException e) {
            LOGGER.error("Failed to remove item from cart - Medicine ID: {}, Patient ID: {}", medicineId, patientId, e);
            throw e;
        }

        // Find the item to be removed
        Set<MedicineCartItem> cartItems = medicineCart.getMedicine_cart_items();
        Optional<MedicineCartItem> itemToRemove = cartItems.stream()
                .filter(item -> item.getMedicineId() == medicineId)
                .findFirst();

        if (itemToRemove.isPresent()) {
            // Calculate the value of the item being removed
            BigDecimal itemValue = itemToRemove.get().getTotalProductPrice();

            // Subtract the item value from the CartTotalPrice
            BigDecimal currentTotalPrice = medicineCart.getCartTotalPrice();
            BigDecimal newTotalPrice = currentTotalPrice.subtract(itemValue);
            medicineCart.setCartTotalPrice(newTotalPrice);

            // Remove the item from the cart
            cartItems.remove(itemToRemove.get());

            // Save the updated cart
            medicineCartRepository.save(medicineCart);
            LOGGER.info("Item removed from the cart successfully.");
        } else {
            LOGGER.error("Item not found in the cart.");
            throw new ResourceNotFoundException("Item not found in the cart.");
        }
    }

    @Override
    public MedicineCart getCartById(long cartId) throws ResourceNotFoundException {
        LOGGER.info("Fetching cart by ID: {}", cartId);

        return medicineCartRepository.findById(cartId)
                .orElseThrow(() -> {
                    LOGGER.error("Cart Not Found with ID: {}", cartId);
                    return new ResourceNotFoundException("Cart Not Found with ID: " + cartId);
                });
    }

    @Override
    public void clearCartItem(long cartId) throws ResourceNotFoundException {
        LOGGER.info("Clearing cart item with ID: {}", cartId);

        MedicineCart cart = getCartById(cartId);
        cart.getMedicine_cart_items().clear();
        double totalPrice = 0.0;
        BigDecimal totalBigDecimal = BigDecimal.valueOf(totalPrice);
        cart.setCartTotalPrice(totalBigDecimal);
        medicineCartRepository.save(cart);
        LOGGER.info("Cart item cleared successfully.");
    }

    @Override
    public List<MedicineCart> getAllCarts() throws DatabaseException {
        LOGGER.info("Fetching all carts");

        List<MedicineCart> carts = medicineCartRepository.findAll();
        return carts;
    }
}
