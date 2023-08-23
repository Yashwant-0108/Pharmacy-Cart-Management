package com.oneHealth.service;

import com.oneHealth.dto.CartItemRequest;
import com.oneHealth.entity.MedicineCart;
import com.oneHealth.exception.ResourceNotFoundException;
import com.oneHealth.exception.ServiceNotAvailableException;


public interface MedicineCartService {
	void addToCart(CartItemRequest itemRequest)throws ResourceNotFoundException;
	MedicineCart getCart(long patientId) throws ResourceNotFoundException, ServiceNotAvailableException; 
	void removeItem(long medicineId , long patientId) throws ResourceNotFoundException ,ServiceNotAvailableException;
	MedicineCart getCartById(long cartId) throws ResourceNotFoundException;
	
	void clearCartItem(long cartId) throws ResourceNotFoundException;
}
