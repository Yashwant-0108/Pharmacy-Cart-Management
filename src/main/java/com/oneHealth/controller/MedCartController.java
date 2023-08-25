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





@RestController
@RequestMapping("/api/medCarts")
public class MedCartController {
	
	
	@Autowired
	private MedicineCartService medicineCartService;
	
	
	@PostMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(@RequestBody CartItemRequest itemRequest) throws ResourceNotFoundException {
        

        try {
            medicineCartService.addToCart(itemRequest);

          
            return ResponseEntity.ok("Medicine added to cart successfully.");
        } catch (ResourceNotFoundException e) {
            
            throw e;
        }
    }
	
	
	 @GetMapping("/{patientId}")
	    public MedicineCart getCart(@PathVariable long patientId) throws ResourceNotFoundException , ServiceNotAvailableException{
	        
			return medicineCartService.getCart(patientId);
	    }
	 
	 
	 @DeleteMapping("/remove-item/{medicineId}/{patientId}")
	    public ResponseEntity<String> removeItem(@PathVariable(value = "medicineId") long medicineId, @PathVariable(value = "patientId") long patientId) throws Exception {
	        

	        try {
				medicineCartService.removeItem(medicineId, patientId);
				
		        return ResponseEntity.ok("Medicine removed from med cart successfully.");
			} catch (ResourceNotFoundException | ServiceNotAvailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}

	        
	    }
	 
	 @GetMapping("/cart/{cartId}")
	    public ResponseEntity<MedicineCart> getCartById(@PathVariable long cartId) throws ResourceNotFoundException{
	    	MedicineCart cart =  medicineCartService.getCartById(cartId);
	    	
			return ResponseEntity.ok(cart);
					
	    }
	 
	 @DeleteMapping("/clearCart/{cartId}")
	 public ResponseEntity<String> clearCartItem(@PathVariable(value="cartId") long cartId )throws ResourceNotFoundException{
			 medicineCartService.clearCartItem(cartId);
			 return ResponseEntity.ok("cart Clear Successfully");

	 }
	
	 @GetMapping("/getAllCarts")
	 public ResponseEntity<List<MedicineCart>> getAllCarts() throws DatabaseException{
		  try {
              List<MedicineCart> carts = medicineCartService.getAllCarts();
              return ResponseEntity.ok(carts);
        } catch (DatabaseException e) {
            throw e;
        }
	 }
	
	
	
	
	
	
	

}
