package com.oneHealth.dto;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;



public class MedicineStock {

    private Integer medicineStockId;

 
    @JsonDeserialize
    private Medicine medicine;

 

    private long pharmaId;

 

    private Integer medicineUnits;

 

    private Date expDate;

 

    private Date mfgDate;

 

    private String batchNo;

 

    private BigDecimal price;

 

    private String packSize;



	@Override
	public String toString() {
		return "MedicineStock [medicineStockId=" + medicineStockId + ", medicine=" + medicine + ", pharmaId=" + pharmaId
				+ ", medicineUnits=" + medicineUnits + ", expDate=" + expDate + ", mfgDate=" + mfgDate + ", batchNo="
				+ batchNo + ", price=" + price + ", packSize=" + packSize + "]";
	}



	public MedicineStock(Integer medicineStockId, Medicine medicine, long pharmaId, Integer medicineUnits,
			Date expDate, Date mfgDate, String batchNo, BigDecimal price, String packSize) {
		super();
		this.medicineStockId = medicineStockId;
		this.medicine = medicine;
		this.pharmaId = pharmaId;
		this.medicineUnits = medicineUnits;
		this.expDate = expDate;
		this.mfgDate = mfgDate;
		this.batchNo = batchNo;
		this.price = price;
		this.packSize = packSize;
	}



	public Integer getMedicineStockId() {
		return medicineStockId;
	}



	public void setMedicineStockId(Integer medicineStockId) {
		this.medicineStockId = medicineStockId;
	}



	public Medicine getMedicine() {
		return medicine;
	}



	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}



	public long getPharmaId() {
		return pharmaId;
	}



	public void setPharmaId(long pharmaId) {
		this.pharmaId = pharmaId;
	}



	public Integer getMedicineUnits() {
		return medicineUnits;
	}



	public void setMedicineUnits(Integer medicineUnits) {
		this.medicineUnits = medicineUnits;
	}



	public Date getExpDate() {
		return expDate;
	}



	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}



	public Date getMfgDate() {
		return mfgDate;
	}



	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}



	public String getBatchNo() {
		return batchNo;
	}



	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public String getPackSize() {
		return packSize;
	}



	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}



	public MedicineStock() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
    
}