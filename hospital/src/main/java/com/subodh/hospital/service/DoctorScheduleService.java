package com.subodh.hospital.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subodh.hospital.controller.DoctorScheduleController;
import com.subodh.hospital.entity.DoctorSchedule;
import com.subodh.hospital.repository.DoctorScheduleRepository;
@Service
public class DoctorScheduleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorScheduleController.class);
	@Autowired
    private DoctorScheduleRepository doctorScheduleRepository;
	
	public void saveDoctorScheduleDetails(DoctorSchedule doctorSchedule) { 
	 	 LOGGER.info("inside saveDoctorScheduleDetails() of DoctorScheduleService doctorSchedule{}:"+doctorSchedule);
	 	 doctorScheduleRepository.save(doctorSchedule);
	 }
	public List<DoctorSchedule> getAllDoctorScheduleDetails(){
		 return doctorScheduleRepository.findAll();
	 }
	public DoctorSchedule findById(Long id) {
	 	 LOGGER.info("inside findById() of DoctorScheduleService id{}:"+id);
		 return doctorScheduleRepository.findById(id).get();
	 }
}
