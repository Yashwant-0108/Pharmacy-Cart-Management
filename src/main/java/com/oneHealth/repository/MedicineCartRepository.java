package com.oneHealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.entity.MedicineCart;

/**
 * Repository interface for managing MedicineCart entities.
 * This interface extends JpaRepository to provide CRUD operations for MedicineCart.
 * It also defines a custom method to find a MedicineCart by patientId.
 * 
 * Make sure to import the required packages, such as org.springframework.data.jpa.repository.JpaRepository.
 * 
 * @author Yashwant
 * @version 1.0
 */
public interface MedicineCartRepository extends JpaRepository<MedicineCart, Long> {
    
    /**
     * Custom method to find a MedicineCart by patientId.
     * 
     * @param patientId The ID of the patient associated with the MedicineCart to be found.
     * @return The MedicineCart associated with the specified patientId, or null if not found.
     */
    MedicineCart findByPatientId(long patientId);
}
