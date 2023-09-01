package com.oneHealth.dto;

public class MedicineCategory {

    private Integer categoryId;        // Unique identifier for the category
    private String images;             // Images related to the category
    private String categoryName;       // Name of the category
    private Integer subCategoryId;     // Identifier for subcategories, if applicable
    private String healthCondition;    // Health condition associated with the category
    private Boolean flag;              // A flag indicating the status of the category

    // Default constructor
    public MedicineCategory() {
        super();
    }

    // Constructor with parameters
    public MedicineCategory(Integer categoryId, String images, String categoryName, Integer subCategoryId,
                            String healthCondition, Boolean flag) {
        super();
        this.categoryId = categoryId;
        this.images = images;
        this.categoryName = categoryName;
        this.subCategoryId = subCategoryId;
        this.healthCondition = healthCondition;
        this.flag = flag;
    }

    // Getter for categoryId
    public Integer getCategoryId() {
        return categoryId;
    }

    // Setter for categoryId
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // Getter for images
    public String getImages() {
        return images;
    }

    // Setter for images
    public void setImages(String images) {
        this.images = images;
    }

    // Getter for categoryName
    public String getCategoryName() {
        return categoryName;
    }

    // Setter for categoryName
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // Getter for subCategoryId
    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    // Setter for subCategoryId
    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    // Getter for healthCondition
    public String getHealthCondition() {
        return healthCondition;
    }

    // Setter for healthCondition
    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    // Getter for flag
    public Boolean getFlag() {
        return flag;
    }

    // Setter for flag
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    // toString method for debugging and logging purposes
    @Override
    public String toString() {
        return "MedicineCategory [categoryId=" + categoryId + ", images=" + images + ", categoryName=" + categoryName
                + ", subCategoryId=" + subCategoryId + ", healthCondition=" + healthCondition + ", flag=" + flag + "]";
    }
}
