package com.oneHealth.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MedicineCartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartItemId;
	private int quantity;
	private long medicineId;
	private BigDecimal totalProductPrice;
	private String medicineName;
	private long pharmaId;
	@JsonBackReference
	@ManyToOne
	private MedicineCart medicineCart;
	public MedicineCartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MedicineCartItem(long cartItemId, int quantity, long medicineId, BigDecimal totalProductPrice,
			String medicineName, long pharmaId, MedicineCart medicineCart) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
		this.medicineId = medicineId;
		this.totalProductPrice = totalProductPrice;
		this.medicineName = medicineName;
		this.pharmaId = pharmaId;
		this.medicineCart = medicineCart;
	}
	@Override
	public String toString() {
		return "MedicineCartItem [cartItemId=" + cartItemId + ", quantity=" + quantity + ", medicineId=" + medicineId
				+ ", totalProductPrice=" + totalProductPrice + ", medicineName=" + medicineName + ", pharmaId="
				+ pharmaId + ", medicineCart=" + medicineCart + "]";
	}
	public long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(long medicineId) {
		this.medicineId = medicineId;
	}
	public BigDecimal getTotalProductPrice() {
		return totalProductPrice;
	}
	public void setTotalProductPrice(BigDecimal totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public long getPharmaId() {
		return pharmaId;
	}
	public void setPharmaId(long pharmaId) {
		this.pharmaId = pharmaId;
	}
	public MedicineCart getMedicineCart() {
		return medicineCart;
	}
	public void setMedicineCart(MedicineCart medicineCart) {
		this.medicineCart = medicineCart;
	}

	
	

}
