package com.subodh.carwale.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subodh.carwale.entity.ModelEntity;
import com.subodh.carwale.repository.ModelRepository;
@Service
public class ModelService {
	 @Autowired
	 private ModelRepository modelRepository;
	 
	 public void saveAllModelDetails(List<ModelEntity> modellist) {
		 modelRepository.saveAll(modellist);	
		}
	 public List<ModelEntity> getAllModelDetails(){
		 return modelRepository.findAll();
	 }
}
