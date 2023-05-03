package com.subodh.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.subodh.hospital.entity.PatientEntity;
public interface PatientRepository extends JpaRepository<PatientEntity,Long>{

}
