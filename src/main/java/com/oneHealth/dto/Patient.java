package com.oneHealth.dto;

import java.sql.Date;

public class Patient {

    private long patientId;         // Unique identifier for the patient
    private long userId;            // Identifier for the associated user
    private String firstName;       // First name of the patient
    private String lastName;        // Last name of the patient
    private String mobileNumber;    // Mobile number of the patient
    private String address;         // Address of the patient
    private int pinCode;            // Pin code of the patient's location
    private String country;         // Country of residence
    private String city;            // City of residence
    private String gender;          // Gender of the patient
    private int age;                // Age of the patient
    private Date dob;               // Date of birth of the patient
    private String bloodGroup;      // Blood group of the patient
    private float height;           // Height of the patient
    private float weight;           // Weight of the patient
    private String maritalStatus;   // Marital status of the patient
    private String emailId;         // Email address of the patient

    // Default constructor
    public Patient() {
        super();
    }

    // Constructor with parameters
    public Patient(long patientId, long userId, String firstName, String lastName, String mobileNumber,
            String address, int pinCode, String country, String city, String gender, int age, Date dob,
            String bloodGroup, float height, float weight, String maritalStatus, String emailId) {
        super();
        this.patientId = patientId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.pinCode = pinCode;
        this.country = country;
        this.city = city;
        this.gender = gender;
        this.age = age;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.height = height;
        this.weight = weight;
        this.maritalStatus = maritalStatus;
        this.emailId = emailId;
    }

    // Getter for patientId
    public long getPatientId() {
        return patientId;
    }

    // Setter for patientId
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    // Getter for userId
    public long getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(long userId) {
        this.userId = userId;
    }

    // Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for mobileNumber
    public String getMobileNumber() {
        return mobileNumber;
    }

    // Setter for mobileNumber
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for pinCode
    public int getPinCode() {
        return pinCode;
    }

    // Setter for pinCode
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    // Getter for country
    public String getCountry() {
        return country;
    }

    // Setter for country
    public void setCountry(String country) {
        this.country = country;
    }

    // Getter for city
    public String getCity() {
        return city;
    }

    // Setter for city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter for gender
    public String getGender() {
        return gender;
    }

    // Setter for gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for dob
    public Date getDob() {
        return dob;
    }

    // Setter for dob
    public void setDob(Date dob) {
        this.dob = dob;
    }

    // Getter for bloodGroup
    public String getBloodGroup() {
        return bloodGroup;
    }

    // Setter for bloodGroup
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    // Getter for height
    public float getHeight() {
        return height;
    }

    // Setter for height
    public void setHeight(float height) {
        this.height = height;
    }

    // Getter for weight
    public float getWeight() {
        return weight;
    }

    // Setter for weight
    public void setWeight(float weight) {
        this.weight = weight;
    }

    // Getter for maritalStatus
    public String getMaritalStatus() {
        return maritalStatus;
    }

    // Setter for maritalStatus
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    // Getter for emailId
    public String getEmailId() {
        return emailId;
    }

    // Setter for emailId
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    // toString method for debugging and logging purposes
    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", userId=" + userId + ", firstName=" + firstName + ", lastName="
                + lastName + ", mobileNumber=" + mobileNumber + ", address=" + address + ", pinCode=" + pinCode
                + ", country=" + country + ", city=" + city + ", gender=" + gender + ", age=" + age + ", dob=" + dob
                + ", bloodGroup=" + bloodGroup + ", height=" + height + ", weight=" + weight + ", maritalStatus="
                + maritalStatus + ", emailId=" + emailId + "]";
    }
}
