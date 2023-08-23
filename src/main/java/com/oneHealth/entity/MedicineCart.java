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

@Entity
public class MedicineCart{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	private long patientId;
	@JsonManagedReference
	@OneToMany(mappedBy="medicineCart",cascade = CascadeType.ALL ,orphanRemoval = true , fetch = FetchType.EAGER)
	private Set<MedicineCartItem> medicine_cart_items = new HashSet<>();
	private BigDecimal cartTotalPrice;
	public BigDecimal getCartTotalPrice() {
		return cartTotalPrice;
	}
	public void setCartTotalPrice(BigDecimal cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}
	public MedicineCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MedicineCart(long cartId, long patientId, Set<MedicineCartItem> medicine_cart_items,
			BigDecimal cartTotalPrice) {
		super();
		this.cartId = cartId;
		this.patientId = patientId;
		this.medicine_cart_items = medicine_cart_items;
		this.cartTotalPrice = cartTotalPrice;
	}
	@Override
	public String toString() {
		return "MedicineCart [cartId=" + cartId + ", patientId=" + patientId + ", medicine_cart_items="
				+ medicine_cart_items + ", cartTotalPrice=" + cartTotalPrice + "]";
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public Set<MedicineCartItem> getMedicine_cart_items() {
		return medicine_cart_items;
	}
	public void setMedicine_cart_items(Set<MedicineCartItem> medicine_cart_items) {
		this.medicine_cart_items = medicine_cart_items;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

