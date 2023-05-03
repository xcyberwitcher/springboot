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
import com.subodh.hospital.entity.Appointment;
import com.subodh.hospital.service.AppointmentService;
@RestController
@RequestMapping(value = AppConstatnt.FORWARDS_SLASH)
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);

	@Value("${logging.file.name}")
	private String loggerPath;
	
	@PostMapping(value = AppConstatnt.Appointment_SAVE_Details)
    public void saveAppointmentDetails(@RequestBody Appointment appointment) {
	    LOGGER.info("inside saveAppointmentDetails() of AppointmentController appointment{}:"+appointment);
		appointmentService.saveAppointmentDetails(appointment);
    }
	@GetMapping(value=AppConstatnt.GET_ALL_APPOINTMENT_DETAILS)
	public @ResponseBody List<Appointment> getAllAppointmentDetails(){	
		return appointmentService.getAllAppointmentDetails();
	}
	@GetMapping(value=AppConstatnt.GET_BY_APPOINTMENT_ID)
	public @ResponseBody Appointment findById(Long id){
		return appointmentService.findById(id);
	}
}
