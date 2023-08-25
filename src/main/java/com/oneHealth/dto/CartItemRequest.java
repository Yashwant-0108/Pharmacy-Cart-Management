package com.oneHealth.dto;

public class CartItemRequest {
	
	private long medicineId;
	private long patientId;
	private int quantity;
	
	public CartItemRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItemRequest(long medicineId, long patientId, int quantity) {
		super();
		this.medicineId = medicineId;
		this.patientId = patientId;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItemRequest [medicineId=" + medicineId + ", patientId=" + patientId + ", quantity=" + quantity
				+ "]";
	}
	public long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(long medicineId) {
		this.medicineId = medicineId;
	}
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
