package com.subodh.esop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.subodh.esop.entity.Allocation;
import com.subodh.esop.entity.Grant;
@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long>{
	
	
    @Query("from Allocation where grant=:grant")
	public Allocation findAllocationByGrantId(Grant grant);
		

}

