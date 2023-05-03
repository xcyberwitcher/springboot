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
import com.subodh.hospital.entity.DoctorSchedule;
import com.subodh.hospital.service.DoctorScheduleService;
@RestController
@RequestMapping(value = AppConstatnt.FORWARDS_SLASH)
public class DoctorScheduleController {
	@Autowired
	private DoctorScheduleService doctorScheduleService;
	
	@Autowired
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorScheduleController.class);

	@Value("${logging.file.name}")
	private String loggerPath;
	
	@PostMapping(value = AppConstatnt.DoctorSchedule_SAVE_Details)
    public void saveDoctorScheduleDetails(@RequestBody DoctorSchedule doctorSchedule) {
	    LOGGER.info("inside saveDoctorScheduleDetails() of DoctorScheduleController doctor{}:"+doctorSchedule);
		doctorScheduleService.saveDoctorScheduleDetails(doctorSchedule);
    }
	@GetMapping(value=AppConstatnt.GET_ALL_DOCTORSCHEDULE_DETAILS)
	public @ResponseBody List<DoctorSchedule> getAllDoctorScheduleDetails(){	
		return doctorScheduleService.getAllDoctorScheduleDetails();
	}
	@GetMapping(value=AppConstatnt.GET_BY_DOCTORSCHEDULE_ID)
	public @ResponseBody DoctorSchedule findById(Long id){
		return doctorScheduleService.findById(id);
	}
}
