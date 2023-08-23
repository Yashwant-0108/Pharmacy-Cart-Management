package com.oneHealth.serviceImpl;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.oneHealth.dto.CartItemRequest;
import com.oneHealth.dto.MedicineStock;
import com.oneHealth.dto.Patient;
import com.oneHealth.entity.MedicineCart;
import com.oneHealth.entity.MedicineCartItem;
import com.oneHealth.exception.ResourceNotFoundException;
import com.oneHealth.exception.ServiceNotAvailableException;
import com.oneHealth.repository.MedicineCartRepository;
import com.oneHealth.service.MedicineCartService;


import jakarta.transaction.Transactional;
@Service
@Transactional
public class MedicineCartServiceImpl implements MedicineCartService {
	@Autowired
	private MedicineCartRepository medicineCartRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	@Autowired
	private WebClient.Builder webClientBuilder;


	@Override
	public void addToCart(CartItemRequest itemRequest) throws ResourceNotFoundException {
		 // Fetch patient details from Patient Management service
	    Patient patientDto = webClientBuilder.build()
	            .get()
	            .uri("https://onehealthpatientmanagement-yjb28-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/patientProfile/{patient_id}",itemRequest.getPatientId())
	            .retrieve()
	            .bodyToMono(Patient.class)
	            .block();
	    System.out.println(patientDto);
	    if (patientDto == null) {
	      
	        throw new ResourceNotFoundException("Patient Not found with Patient id : " + itemRequest.getPatientId());
	    }
	
	
	
//	Fetching Medicine Details
	MedicineStock medicineArray [] =webClientBuilder.build()
			    .get()
			    .uri("https://apigateway-yjb28-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/InventoryManagement/medicineStock/byMedicineID/{id}",
			    		  itemRequest.getMedicineId())
	            .retrieve()
	            .bodyToMono(MedicineStock[].class)
	            .block();
	MedicineStock medicine = medicineArray[0];
	
	    
//	    Medicine medicine = new Medicine(1, "Paracetamol", 10, "Fever and pain relief", 1,
//                "ABC Pharmacy", "New York", "123 Main St");
//	    System.out.println(medicine);
	    
	    
	    if (medicine == null) {
	       
	        throw new ResourceNotFoundException("Medicine Not found with Medicine id : " + itemRequest.getMedicineId());
	    }
	    
	    
	    MedicineCartItem cartItem = new MedicineCartItem();
	    cartItem.setQuantity(itemRequest.getQuantity());
	    cartItem.setMedicineId(itemRequest.getMedicineId());
	    BigDecimal totalPrice = medicine.getPrice()
	    		.multiply(BigDecimal.valueOf(itemRequest.getQuantity()));
	    cartItem.setTotalProductPrice(totalPrice);
	    
	    
	    MedicineCart medicineCart = medicineCartRepository.findByPatientId(itemRequest.getPatientId());
	    if (medicineCart == null) {
	    	medicineCart = new MedicineCart();
	    	medicineCart.setPatientId(itemRequest.getPatientId());
	    	medicineCart.setCartTotalPrice(totalPrice);
	    }
	    else {
		    medicineCart.setCartTotalPrice(medicineCart.getCartTotalPrice().add(totalPrice));
	    }
	    cartItem.setMedicineCart(medicineCart);
	    Set<MedicineCartItem> items = medicineCart.getMedicine_cart_items();
	    AtomicReference<Boolean> flag=new AtomicReference<>(false);
        Set<MedicineCartItem> newitem= items.stream().map((i) -> {
        	
        	if(i.getMedicineId() == medicine.getMedicine().getMedicineId()) {
        		
        		int quantity = itemRequest.getQuantity()+i.getQuantity();
        		i.setQuantity(quantity);
        		 BigDecimal total = medicine.getPrice().multiply(BigDecimal.valueOf(quantity));
        		i.setTotalProductPrice(total);
        		flag.set(true);
        	}
        	
        	return i;
        }).collect(Collectors.toSet());
        
        if(flag.get()) {
        	items.clear();
        	items.addAll(newitem);
        	
        }
        else {
        	cartItem.setMedicineCart(medicineCart);
			items.add(cartItem);
        }
	    
	    
	    
	    
	    	 cartItem.setMedicineName(medicine.getMedicine().getMedicineName());
	    
//	    
	   
	   
//	    labCart.getCart_items().add(cartItem);
//System.out.println(labCart);
	    medicineCartRepository.save(medicineCart);
	    

	   
	}

	    

	@Override
	public MedicineCart getCart(long patientId) throws ResourceNotFoundException, ServiceNotAvailableException {
		 Patient patientDto = webClientBuilder.build()
				    .get()
				    .uri("https://onehealthpatientmanagement-yjb28-dev.apps.sandbox-m4.g2pi.p1.openshiftapps.com/patientProfile/{test_id}", patientId)
				    .retrieve()
				    .bodyToMono(Patient.class)
				    .block();
			    

				if (patientDto == null) {
				
				    throw new ResourceNotFoundException("Patient not found with Patient ID: " + patientId);
				}

				MedicineCart cart = medicineCartRepository.findByPatientId(patientId);
				return cart;
	}


	@Override
	public void removeItem(long medicineId, long patientId) throws ResourceNotFoundException, ServiceNotAvailableException {
	    MedicineCart medicineCart;
	    try {
	        medicineCart = this.mapper.map(getCart(patientId), MedicineCart.class);
	    } catch (ResourceNotFoundException e) {
	        e.printStackTrace();
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
	    } else {
	        throw new ResourceNotFoundException("Item not found in the cart.");
	    }
	}



	@Override
	public MedicineCart getCartById(long cartId) throws ResourceNotFoundException {
		
		return medicineCartRepository.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("Cart Not Found !!"));
	}



	@Override
	public void clearCartItem(long cartId) throws ResourceNotFoundException {
		MedicineCart cart = getCartById(cartId);
		cart.getMedicine_cart_items().clear();
		double totalPrice = 0.0;
		BigDecimal totalBigDecimal = BigDecimal.valueOf(totalPrice);
		cart.setCartTotalPrice(totalBigDecimal);
		medicineCartRepository.save(cart);
		
	}

}
