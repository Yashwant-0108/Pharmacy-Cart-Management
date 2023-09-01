package com.oneHealth.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class MedicineStock {

    private Integer medicineStockId;    // Unique identifier for medicine stock

    @JsonDeserialize
    private Medicine medicine;          // Medicine information associated with the stock

    private long pharmaId;              // Identifier for the pharmacy where the stock is located

    private Integer medicineUnits;      // Number of units of medicine in stock

    private Date expDate;               // Expiration date of the medicine stock

    private Date mfgDate;               // Manufacturing date of the medicine stock

    private String batchNo;             // Batch number associated with the medicine stock

    private BigDecimal price;           // Price of the medicine stock

    private String packSize;            // Size or packaging information of the medicine stock

    private String pharmaName;          // Name of the pharmacy

    private String pharmaAddress;       // Address of the pharmacy

    // Default constructor
    public MedicineStock() {
        super();
    }

    // Constructor with parameters
    public MedicineStock(Integer medicineStockId, Medicine medicine, long pharmaId, Integer medicineUnits, Date expDate,
            Date mfgDate, String batchNo, BigDecimal price, String packSize, String pharmaName, String pharmaAddress) {
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
        this.pharmaName = pharmaName;
        this.pharmaAddress = pharmaAddress;
    }

    // Getter for medicineStockId
    public Integer getMedicineStockId() {
        return medicineStockId;
    }

    // Setter for medicineStockId
    public void setMedicineStockId(Integer medicineStockId) {
        this.medicineStockId = medicineStockId;
    }

    // Getter for medicine
    public Medicine getMedicine() {
        return medicine;
    }

    // Setter for medicine
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    // Getter for pharmaId
    public long getPharmaId() {
        return pharmaId;
    }

    // Setter for pharmaId
    public void setPharmaId(long pharmaId) {
        this.pharmaId = pharmaId;
    }

    // Getter for medicineUnits
    public Integer getMedicineUnits() {
        return medicineUnits;
    }

    // Setter for medicineUnits
    public void setMedicineUnits(Integer medicineUnits) {
        this.medicineUnits = medicineUnits;
    }

    // Getter for expDate
    public Date getExpDate() {
        return expDate;
    }

    // Setter for expDate
    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    // Getter for mfgDate
    public Date getMfgDate() {
        return mfgDate;
    }

    // Setter for mfgDate
    public void setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
    }

    // Getter for batchNo
    public String getBatchNo() {
        return batchNo;
    }

    // Setter for batchNo
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    // Getter for price
    public BigDecimal getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Getter for packSize
    public String getPackSize() {
        return packSize;
    }

    // Setter for packSize
    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    // Getter for pharmaName
    public String getPharmaName() {
        return pharmaName;
    }

    // Setter for pharmaName
    public void setPharmaName(String pharmaName) {
        this.pharmaName = pharmaName;
    }

    // Getter for pharmaAddress
    public String getPharmaAddress() {
        return pharmaAddress;
    }

    // Setter for pharmaAddress
    public void setPharmaAddress(String pharmaAddress) {
        this.pharmaAddress = pharmaAddress;
    }

    // toString method for debugging and logging purposes
    @Override
    public String toString() {
        return "MedicineStock [medicineStockId=" + medicineStockId + ", medicine=" + medicine + ", pharmaId=" + pharmaId
                + ", medicineUnits=" + medicineUnits + ", expDate=" + expDate + ", mfgDate=" + mfgDate + ", batchNo="
                + batchNo + ", price=" + price + ", packSize=" + packSize + ", pharmaName=" + pharmaName
                + ", pharmaAddress=" + pharmaAddress + "]";
    }
}
