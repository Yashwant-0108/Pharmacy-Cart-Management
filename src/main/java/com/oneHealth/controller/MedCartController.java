package com.oneHealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneHealth.dto.CartItemRequest;
import com.oneHealth.entity.MedicineCart;
import com.oneHealth.exception.DatabaseException;
import com.oneHealth.exception.ResourceNotFoundException;
import com.oneHealth.exception.ServiceNotAvailableException;
import com.oneHealth.service.MedicineCartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/medCarts")
public class MedCartController {

    // Logger for logging messages
    private static final Logger LOGGER = LoggerFactory.getLogger(MedCartController.class);

    @Autowired
    private MedicineCartService medicineCartService;

    /**
     * Endpoint to add a medicine to the cart.
     *
     * @param itemRequest The request containing information about the medicine to be added.
     * @return ResponseEntity with a success message.
     * @throws ResourceNotFoundException If the resource is not found.
     */
    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody CartItemRequest itemRequest) throws ResourceNotFoundException {
        LOGGER.info("Adding medicine to cart.");
        try {
            medicineCartService.addToCart(itemRequest);
            LOGGER.info("Medicine added to cart successfully.");
            return ResponseEntity.ok("Medicine added to cart successfully.");
        } catch (ResourceNotFoundException e) {
            LOGGER.error("Failed to add medicine to cart: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Endpoint to get the cart for a specific patient.
     *
     * @param patientId The ID of the patient.
     * @return The MedicineCart object representing the patient's cart.
     * @throws ResourceNotFoundException If the resource is not found.
     * @throws ServiceNotAvailableException If the service is not available.
     */
    @GetMapping("/{patientId}")
    public MedicineCart getCart(@PathVariable long patientId) throws ResourceNotFoundException, ServiceNotAvailableException {
        LOGGER.info("Fetching cart for patient with ID: {}.", patientId);
        return medicineCartService.getCart(patientId);
    }

    /**
     * Endpoint to remove an item from the cart.
     *
     * @param medicineId The ID of the medicine to remove.
     * @param patientId  The ID of the patient.
     * @return ResponseEntity with a success message.
     * @throws Exception If an error occurs during removal.
     */
    @DeleteMapping("/remove-item/{medicineId}/{patientId}")
    public ResponseEntity<String> removeItem(@PathVariable(value = "medicineId") long medicineId,
            @PathVariable(value = "patientId") long patientId) throws Exception {
        LOGGER.info("Removing medicine with ID: {} from cart for patient with ID: {}.", medicineId, patientId);
        try {
            medicineCartService.removeItem(medicineId, patientId);
            LOGGER.info("Medicine removed from cart successfully.");
            return ResponseEntity.ok("Medicine removed from med cart successfully.");
        } catch (ResourceNotFoundException | ServiceNotAvailableException e) {
            LOGGER.error("Failed to remove medicine from cart: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Endpoint to get a cart by its ID.
     *
     * @param cartId The ID of the cart to retrieve.
     * @return ResponseEntity containing the MedicineCart object.
     * @throws ResourceNotFoundException If the cart is not found.
     */
    @GetMapping("/cart/{cartId}")
    public ResponseEntity<MedicineCart> getCartById(@PathVariable long cartId) throws ResourceNotFoundException {
        LOGGER.info("Fetching cart by ID: {}.", cartId);
        MedicineCart cart = medicineCartService.getCartById(cartId);
        return ResponseEntity.ok(cart);
    }

    /**
     * Endpoint to clear all items from a cart.
     *
     * @param cartId The ID of the cart to clear.
     * @return ResponseEntity with a success message.
     * @throws ResourceNotFoundException If the cart is not found.
     */
    @DeleteMapping("/clearCart/{cartId}")
    public ResponseEntity<String> clearCartItem(@PathVariable(value = "cartId") long cartId)
            throws ResourceNotFoundException {
        LOGGER.info("Clearing cart with ID: {}.", cartId);
        medicineCartService.clearCartItem(cartId);
        LOGGER.info("Cart cleared successfully.");
        return ResponseEntity.ok("Cart cleared successfully");
    }

    /**
     * Endpoint to get all carts.
     *
     * @return ResponseEntity containing a list of MedicineCart objects.
     * @throws DatabaseException If a database error occurs.
     */
    @GetMapping("/getAllCarts")
    public ResponseEntity<List<MedicineCart>> getAllCarts() throws DatabaseException {
        LOGGER.info("Fetching all carts.");
        try {
            List<MedicineCart> carts = medicineCartService.getAllCarts();
            LOGGER.info("Fetched {} carts.", carts.size());
            return ResponseEntity.ok(carts);
        } catch (DatabaseException e) {
            LOGGER.error("Failed to fetch carts: {}", e.getMessage());
            throw e;
        }
    }
}
