package com.oneHealth.dto;

public class MedicineCategory {

	 

    private Integer categoryId;

 


    private String images;

 


    private String categoryName;

 


    private Integer subCategoryId;

 


    private String healthCondition;

 


    private Boolean flag;

 

    public MedicineCategory() {

        super();

        // TODO Auto-generated constructor stub

    }

 

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

 

    @Override

    public String toString() {

        return "MedicineCategory [categoryId=" + categoryId + ", images=" + images + ", categoryName=" + categoryName

                + ", subCategoryId=" + subCategoryId + ", healthCondition=" + healthCondition + ", flag=" + flag + "]";

    }

 

    public Integer getCategoryId() {

        return categoryId;

    }

 

    public void setCategoryId(Integer categoryId) {

        this.categoryId = categoryId;

    }

 

    public String getImages() {

        return images;

    }

 

    public void setImages(String images) {

        this.images = images;

    }

 

    public String getCategoryName() {

        return categoryName;

    }

 

    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;

    }

 

    public Integer getSubCategoryId() {

        return subCategoryId;

    }

 

    public void setSubCategoryId(Integer subCategoryId) {

        this.subCategoryId = subCategoryId;

    }

 

    public String getHealthCondition() {

        return healthCondition;

    }

 

    public void setHealthCondition(String healthCondition) {

        this.healthCondition = healthCondition;

    }

 

    public Boolean getFlag() {

        return flag;

    }

 

    public void setFlag(Boolean flag) {

        this.flag = flag;

    }

    

    

 

}