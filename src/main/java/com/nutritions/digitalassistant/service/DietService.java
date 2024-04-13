package com.nutritions.digitalassistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nutritions.digitalassistant.dto.MedicalDataDTO;
import com.nutritions.digitalassistant.model.Diet;
import com.nutritions.digitalassistant.repository.DietRepository;

@Service
public class DietService {

	@Autowired
	private DietRepository dietRepository;

	@Autowired
	MedicalDataService medicalDataService;

	public Diet saveDiet(MedicalDataDTO medicalDataDTO) {
		Diet diet = new Diet();
		diet.setIdUser(medicalDataDTO.getIdUser());
		diet.setType(medicalDataDTO.getTypeDiet());
		medicalDataService.parseMedicalData(medicalDataDTO);

		return dietRepository.save(diet);

	}

}
