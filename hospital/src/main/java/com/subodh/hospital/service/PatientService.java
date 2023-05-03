package com.subodh.hospital.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subodh.hospital.controller.PatientController;
import com.subodh.hospital.entity.PatientEntity;
import com.subodh.hospital.repository.PatientRepository;
@Service
public class PatientService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
	@Autowired
    private PatientRepository patientRepository;
	
	public void savePatientDetails(PatientEntity patient) { 
	 	 LOGGER.info("inside savePatientDetails() of PatientService Patient{}:"+patient);
	 	patientRepository.save(patient);
	 }
	
	public List<PatientEntity> getAllPatientDetails(){
		 return patientRepository.findAll();
	 }
	
	public PatientEntity findById(Long id) {
	 	 LOGGER.info("inside findByDoctorId() of PatientService id{}:"+id);
		 return patientRepository.findById(id).get();
	 }
}
