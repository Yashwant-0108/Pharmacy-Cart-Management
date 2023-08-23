package com.oneHealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneHealth.entity.MedicineCart;

public interface MedicineCartRepository extends JpaRepository<MedicineCart,Long>{
	
	MedicineCart findByPatientId(long patientId);

}
