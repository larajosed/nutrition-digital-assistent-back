package com.nutritions.digitalassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritions.digitalassistant.dto.MedicalDataDTO;
import com.nutritions.digitalassistant.model.MedicalData;
import com.nutritions.digitalassistant.repository.MedicalDataRepository;

@Service
public class MedicalDataService {

	@Autowired
	private MedicalDataRepository medicalDataRepository;

	public MedicalData parseMedicalData(MedicalDataDTO medicalDataDTO) {
		Integer id = medicalDataDTO.getId();
		MedicalData medicalData;
		if (id != null) {
			medicalData = getMedicalDataById(id);
		} else  {
			medicalData = new MedicalData();
		}
		medicalData.setIdUser(medicalDataDTO.getIdUser());
		medicalData.setHeight(medicalDataDTO.getHeight());
		medicalData.setWeight(medicalDataDTO.getWeight());
		medicalData.setCurrentMedical(medicalDataDTO.getCurrentMedical());
		medicalData.setFamilyBackground(medicalDataDTO.getFamilyBackground());
		medicalData.setActivityLevel(medicalDataDTO.getActivityLevel());
		medicalData.setAllergies(medicalDataDTO.getAllergies());
		medicalData.setMedicalInformation(medicalDataDTO.getMedicalInformation());

		return medicalDataRepository.save(medicalData);

	}

	public MedicalData getMedicalDataById(Integer id) {
		return medicalDataRepository.findById(id).get();

	}

}
