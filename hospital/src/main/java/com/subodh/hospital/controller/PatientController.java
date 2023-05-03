package com.subodh.hospital.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.subodh.hospital.constant.AppConstatnt;
import com.subodh.hospital.entity.PatientEntity;
import com.subodh.hospital.service.PatientService;
@RestController
@RequestMapping(value = AppConstatnt.FORWARDS_SLASH)
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@Value("${logging.file.name}")
	private String loggerPath;
	
	@PostMapping(value = AppConstatnt.Patient_SAVE_Details)
    public void savePatientDetails(@RequestBody PatientEntity patient) {
	    LOGGER.info("inside savePatientDetails() of PatientController patient{}:"+patient);
		patientService.savePatientDetails(patient);
    }
	@GetMapping(value=AppConstatnt.GET_ALL_PATIENT_DETAILS)
	public @ResponseBody List<PatientEntity> getAllPatientDetails(){	
		return patientService.getAllPatientDetails();
	}
	@GetMapping(value=AppConstatnt.GET_BY_PATIENTID)
	public @ResponseBody PatientEntity findById(Long id){
		return patientService.findById(id);
	}
}
