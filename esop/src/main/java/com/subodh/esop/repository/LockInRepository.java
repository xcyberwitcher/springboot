package com.subodh.esop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.subodh.esop.entity.LockIn;
@Repository
public interface LockInRepository extends JpaRepository<LockIn, Long>{
	
	@Query("from LockIn where employeeNumber=:employeeNumber")
	public LockIn findByLockInByEmployeeNumber(String employeeNumber);

}

