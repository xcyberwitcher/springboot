package com.subodh.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.subodh.hospital.entity.DoctorSchedule;
public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule,Long>{

}
