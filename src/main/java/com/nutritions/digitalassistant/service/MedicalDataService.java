package com.nutritions.digitalassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutritions.digitalassistant.dto.MedicalDataDto;
import com.nutritions.digitalassistant.model.MedicalData;
import com.nutritions.digitalassistant.repository.MedicalDataRepository;

@Service
public class MedicalDataService {

	@Autowired
	private MedicalDataRepository medicalDataRepository;

	public MedicalData parseMedicalData(MedicalDataDto medicalDataDto) {
		Integer id = medicalDataDto.getId();
		MedicalData medicalData;
		if (id != null) {
			medicalData = getMedicalDataById(id);
		} else  {
			medicalData = new MedicalData();
		}
		medicalData.setIdUser(medicalDataDto.getIdUser());
		medicalData.setHeight(medicalDataDto.getHeight());
		medicalData.setWeight(medicalDataDto.getWeight());
		medicalData.setCurrentMedical(medicalDataDto.getCurrentMedical());
		medicalData.setFamilyBackground(medicalDataDto.getFamilyBackground());
		medicalData.setActivityLevel(medicalDataDto.getActivityLevel());
		medicalData.setAllergies(medicalDataDto.getAllergies());
		medicalData.setMedicalInformation(medicalDataDto.getMedicalInformation());

		return medicalDataRepository.save(medicalData);

	}

	public MedicalData getMedicalDataById(Integer idUser) {
		return medicalDataRepository.findByIdUser(idUser).get();

	}

}
