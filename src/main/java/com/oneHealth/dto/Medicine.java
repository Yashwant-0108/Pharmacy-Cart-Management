package com.oneHealth.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Medicine {

    private int medicineId;

    @JsonDeserialize
    private MedicineCategory category;

    private String medicineName;

    private String medicineImages;

    private Boolean medicineAvailability;

    // Default constructor
    public Medicine() {
        super();
    }

    // Constructor with parameters
    public Medicine(Integer medicineId, MedicineCategory category, String medicineName, String medicineImages,
            Boolean medicineAvailability) {
        super();
        this.medicineId = medicineId;
        this.category = category;
        this.medicineName = medicineName;
        this.medicineImages = medicineImages;
        this.medicineAvailability = medicineAvailability;
    }

    // Getter for medicineId
    public Integer getMedicineId() {
        return medicineId;
    }

    // Setter for medicineId
    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    // Getter for category
    public MedicineCategory getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(MedicineCategory category) {
        this.category = category;
    }

    // Getter for medicineName
    public String getMedicineName() {
        return medicineName;
    }

    // Setter for medicineName
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    // Getter for medicineImages
    public String getMedicineImages() {
        return medicineImages;
    }

    // Setter for medicineImages
    public void setMedicineImages(String medicineImages) {
        this.medicineImages = medicineImages;
    }

    // Getter for medicineAvailability
    public Boolean getMedicineAvailability() {
        return medicineAvailability;
    }

    // Setter for medicineAvailability
    public void setMedicineAvailability(Boolean medicineAvailability) {
        this.medicineAvailability = medicineAvailability;
    }

    // toString method for debugging and logging purposes
    @Override
    public String toString() {
        return "Medicine [medicineId=" + medicineId + ", category=" + category + ", medicineName=" + medicineName
                + ", medicineImages=" + medicineImages + ", medicineAvailability=" + medicineAvailability + "]";
    }
}
