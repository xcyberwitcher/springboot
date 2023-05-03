package com.subodh.hospital.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subodh.hospital.controller.AppointmentController;
import com.subodh.hospital.entity.Appointment;
import com.subodh.hospital.repository.AppointmentRepository;
@Service
public class AppointmentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	@Autowired
    private AppointmentRepository appointmentRepository;
	
	/**
	 * This method  will save AppointmentDetails
	 * @param appointment
	 */
	public void saveAppointmentDetails(Appointment appointment) { 
	 	 LOGGER.info("inside saveAppointmentDetails() of AppointmentService appointment{}:"+appointment);
	 	 appointmentRepository.save(appointment);
	 }
	public List<Appointment> getAllAppointmentDetails(){
		 return appointmentRepository.findAll();
	 }
	public Appointment findById(Long id) {
	 	 LOGGER.info("inside findById() of AppointmentService id{}:"+id);
		 return appointmentRepository.findById(id).get();
	 }
}
