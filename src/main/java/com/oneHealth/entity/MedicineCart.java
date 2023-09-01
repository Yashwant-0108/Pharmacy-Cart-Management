package com.oneHealth.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



/**
* Entity class representing DoctorSchedule information.
* This class is mapped to a database table to store schedule details of doctors.
*
* Note: Make sure to import the required annotations from the appropriate packages.
*
* @author Yashwant
* @version 1.0
*/

@Entity
public class MedicineCart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId; // Primary key field for the MedicineCart table
    
    private long patientId; // ID of the patient associated with this cart
    
    @JsonManagedReference
    @OneToMany(mappedBy = "medicineCart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<MedicineCartItem> medicine_cart_items = new HashSet<>(); // Set to store MedicineCartItem objects
    
    private BigDecimal cartTotalPrice; // Total price of items in the cart
    
    // Getter and setter methods for cartTotalPrice
    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }
    
    // Default constructor
    public MedicineCart() {
        super();
    }

    // Parameterized constructor to initialize MedicineCart object with values
    public MedicineCart(long cartId, long patientId, Set<MedicineCartItem> medicine_cart_items, BigDecimal cartTotalPrice) {
        super();
        this.cartId = cartId;
        this.patientId = patientId;
        this.medicine_cart_items = medicine_cart_items;
        this.cartTotalPrice = cartTotalPrice;
    }

    // Getter method for cartId
    public long getCartId() {
        return cartId;
    }

    // Setter method for cartId
    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    // Getter method for patientId
    public long getPatientId() {
        return patientId;
    }

    // Setter method for patientId
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    // Getter method for medicine_cart_items
    public Set<MedicineCartItem> getMedicine_cart_items() {
        return medicine_cart_items;
    }

    // Setter method for medicine_cart_items
    public void setMedicine_cart_items(Set<MedicineCartItem> medicine_cart_items) {
        this.medicine_cart_items = medicine_cart_items;
    }

    @Override
    public String toString() {
        return "MedicineCart [cartId=" + cartId + ", patientId=" + patientId + ", medicine_cart_items="
                + medicine_cart_items + ", cartTotalPrice=" + cartTotalPrice + "]";
    }
}
