package com.oneHealth.service;

import java.util.List;

import com.oneHealth.dto.CartItemRequest;
import com.oneHealth.entity.MedicineCart;
import com.oneHealth.exception.DatabaseException;
import com.oneHealth.exception.ResourceNotFoundException;
import com.oneHealth.exception.ServiceNotAvailableException;

/**
 * Service interface for managing MedicineCart entities.
 * This interface defines methods for adding items to a cart, retrieving a cart by patientId,
 * removing items from a cart, retrieving a cart by cartId, clearing cart items, and getting all carts.
 * 
 * Make sure to import the required packages, such as com.oneHealth.dto.CartItemRequest.
 * 
 * @author Yashwant
 * @version 1.0
 */
public interface MedicineCartService {
    
    /**
     * Add an item to the cart.
     * 
     * @param itemRequest The request object containing information about the item to be added to the cart.
     * @throws ResourceNotFoundException If the requested resource is not found.
     */
    void addToCart(CartItemRequest itemRequest) throws ResourceNotFoundException;
    
    /**
     * Get the cart associated with a patient by patientId.
     * 
     * @param patientId The ID of the patient for whom the cart is retrieved.
     * @return The MedicineCart associated with the specified patientId.
     * @throws ResourceNotFoundException If the requested resource is not found.
     * @throws ServiceNotAvailableException If the service is not available.
     */
    MedicineCart getCart(long patientId) throws ResourceNotFoundException, ServiceNotAvailableException;
    
    /**
     * Remove an item from the cart.
     * 
     * @param medicineId The ID of the medicine to be removed from the cart.
     * @param patientId The ID of the patient whose cart is updated.
     * @throws ResourceNotFoundException If the requested resource is not found.
     * @throws ServiceNotAvailableException If the service is not available.
     */
    void removeItem(long medicineId, long patientId) throws ResourceNotFoundException, ServiceNotAvailableException;
    
    /**
     * Get a cart by its cartId.
     * 
     * @param cartId The ID of the cart to be retrieved.
     * @return The MedicineCart associated with the specified cartId.
     * @throws ResourceNotFoundException If the requested resource is not found.
     */
    MedicineCart getCartById(long cartId) throws ResourceNotFoundException;
    
    /**
     * Clear all items from a cart.
     * 
     * @param cartId The ID of the cart from which items will be cleared.
     * @throws ResourceNotFoundException If the requested resource is not found.
     */
    void clearCartItem(long cartId) throws ResourceNotFoundException;
    
    /**
     * Get a list of all carts.
     * 
     * @return A list of all MedicineCarts in the system.
     * @throws DatabaseException If there is an issue with the database.
     */
    List<MedicineCart> getAllCarts() throws DatabaseException;
}
