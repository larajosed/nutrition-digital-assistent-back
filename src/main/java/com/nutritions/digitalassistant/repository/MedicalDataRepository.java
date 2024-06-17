package com.nutritions.digitalassistant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nutritions.digitalassistant.model.MedicalData;

public interface MedicalDataRepository extends JpaRepository <MedicalData, Integer> {
	Optional<MedicalData> findByIdUser(Integer idUser);
	
}
