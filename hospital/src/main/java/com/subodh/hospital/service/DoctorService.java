package com.subodh.hospital.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subodh.hospital.controller.DoctorController;
import com.subodh.hospital.entity.DoctorEntity;
import com.subodh.hospital.repository.DoctorRepository;
@Service
public class DoctorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	@Autowired
    private DoctorRepository doctorRepository;
	
	public void saveDoctorDetails(DoctorEntity doctor) { 
	 	 LOGGER.info("inside saveDoctorDetails() of DoctorService doctor{}:"+doctor);
	 	 doctorRepository.save(doctor);
	 }
	public List<DoctorEntity> getAllDoctorDetails(){
		 return doctorRepository.findAll();
	 }
	public DoctorEntity findById(Long id) {
	 	 LOGGER.info("inside findById() of DoctorService id{}:"+id);
		 return doctorRepository.findById(id).get();
	 }
}
