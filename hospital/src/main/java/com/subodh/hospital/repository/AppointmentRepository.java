package com.subodh.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.subodh.hospital.entity.Appointment;
public interface AppointmentRepository extends  JpaRepository<Appointment,Long>{

}
