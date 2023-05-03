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
import com.subodh.hospital.entity.DoctorEntity;
import com.subodh.hospital.service.DoctorService;
@RestController
@RequestMapping(value = AppConstatnt.FORWARDS_SLASH)
public class DoctorController {
  
	@Autowired
	private DoctorService doctorService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);

	@Value("${logging.file.name}")
	private String loggerPath;
	
	@PostMapping(value = AppConstatnt.Doctor_SAVE_Details)
    public void saveDoctorDetails(@RequestBody DoctorEntity doctor) {
	    LOGGER.info("inside saveDoctorDetails() of DoctorController doctor{}:"+doctor);
		doctorService.saveDoctorDetails(doctor);
    }
	@GetMapping(value=AppConstatnt.GET_ALL_DOCTOR_DETAILS)
	public @ResponseBody List<DoctorEntity> getAllRegisterDetails(){	
		return doctorService.getAllDoctorDetails();
	}
	@GetMapping(value=AppConstatnt.GET_BY_DOCTORID)
	public @ResponseBody DoctorEntity findById(Long id){
		return doctorService.findById(id);
	}
	
	
}
