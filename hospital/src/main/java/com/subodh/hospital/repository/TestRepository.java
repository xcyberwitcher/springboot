package com.subodh.hospital.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.subodh.hospital.entity.TestEntity;
public interface TestRepository extends JpaRepository<TestEntity,Long>{

}
