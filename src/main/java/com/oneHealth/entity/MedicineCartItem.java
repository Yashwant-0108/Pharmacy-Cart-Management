package com.oneHealth.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


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
public class MedicineCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId; // Primary key field for the MedicineCartItem table
    
    private int quantity; // Quantity of the medicine in the cart
    private long medicineId; // ID of the medicine associated with this cart item
    private BigDecimal totalProductPrice; // Total price of the medicine(s) in this cart item
    private String medicineName; // Name of the medicine
    private long pharmaId; // ID of the pharmacy selling this medicine
    private String pharmaName; // Name of the pharmacy
    private String pharmaAddress; // Address of the pharmacy
    
    @JsonBackReference
    @ManyToOne
    private MedicineCart medicineCart; // Reference to the MedicineCart this item belongs to
    
    // Default constructor
    public MedicineCartItem() {
        super();
    }

    // Parameterized constructor to initialize MedicineCartItem object with values
    public MedicineCartItem(long cartItemId, int quantity, long medicineId, BigDecimal totalProductPrice,
            String medicineName, long pharmaId, String pharmaName, String pharmaAddress, MedicineCart medicineCart) {
        super();
        this.cartItemId = cartItemId;
        this.quantity = quantity;
        this.medicineId = medicineId;
        this.totalProductPrice = totalProductPrice;
        this.medicineName = medicineName;
        this.pharmaId = pharmaId;
        this.pharmaName = pharmaName;
        this.pharmaAddress = pharmaAddress;
        this.medicineCart = medicineCart;
    }

    // Getter method for cartItemId
    public long getCartItemId() {
        return cartItemId;
    }

    // Setter method for cartItemId
    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    // Getter method for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter method for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter method for medicineId
    public long getMedicineId() {
        return medicineId;
    }

    // Setter method for medicineId
    public void setMedicineId(long medicineId) {
        this.medicineId = medicineId;
    }

    // Getter method for totalProductPrice
    public BigDecimal getTotalProductPrice() {
        return totalProductPrice;
    }

    // Setter method for totalProductPrice
    public void setTotalProductPrice(BigDecimal totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    // Getter method for medicineName
    public String getMedicineName() {
        return medicineName;
    }

    // Setter method for medicineName
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    // Getter method for pharmaId
    public long getPharmaId() {
        return pharmaId;
    }

    // Setter method for pharmaId
    public void setPharmaId(long pharmaId) {
        this.pharmaId = pharmaId;
    }

    // Getter method for pharmaName
    public String getPharmaName() {
        return pharmaName;
    }

    // Setter method for pharmaName
    public void setPharmaName(String pharmaName) {
        this.pharmaName = pharmaName;
    }

    // Getter method for pharmaAddress
    public String getPharmaAddress() {
        return pharmaAddress;
    }

    // Setter method for pharmaAddress
    public void setPharmaAddress(String pharmaAddress) {
        this.pharmaAddress = pharmaAddress;
    }

    // Getter method for medicineCart
    public MedicineCart getMedicineCart() {
        return medicineCart;
    }

    // Setter method for medicineCart
    public void setMedicineCart(MedicineCart medicineCart) {
        this.medicineCart = medicineCart;
    }

    @Override
    public String toString() {
        return "MedicineCartItem [cartItemId=" + cartItemId + ", quantity=" + quantity + ", medicineId=" + medicineId
                + ", totalProductPrice=" + totalProductPrice + ", medicineName=" + medicineName + ", pharmaId="
                + pharmaId + ", pharmaName=" + pharmaName + ", pharmaAddress=" + pharmaAddress + ", medicineCart="
                + medicineCart + "]";
    }
}
