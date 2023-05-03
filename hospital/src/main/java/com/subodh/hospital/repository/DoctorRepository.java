package com.subodh.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.subodh.hospital.entity.DoctorEntity;
public interface DoctorRepository extends  JpaRepository<DoctorEntity,Long>{
	 
}
