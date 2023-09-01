package com.oneHealth.dto;

public class CartItemRequest {
	
	private long medicineId;
	private long patientId;
	private int quantity;
	
	// Default constructor
	public CartItemRequest() {
		super();
	}
	
	// Constructor with parameters
	public CartItemRequest(long medicineId, long patientId, int quantity) {
		super();
		this.medicineId = medicineId;
		this.patientId = patientId;
		this.quantity = quantity;
	}
	
	// toString method for debugging and logging purposes
	@Override
	public String toString() {
		return "CartItemRequest [medicineId=" + medicineId + ", patientId=" + patientId + ", quantity=" + quantity
				+ "]";
	}
	
	// Getter for medicineId
	public long getMedicineId() {
		return medicineId;
	}
	
	// Setter for medicineId
	public void setMedicineId(long medicineId) {
		this.medicineId = medicineId;
	}
	
	// Getter for patientId
	public long getPatientId() {
		return patientId;
	}
	
	// Setter for patientId
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	
	// Getter for quantity
	public int getQuantity() {
		return quantity;
	}
	
	// Setter for quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
