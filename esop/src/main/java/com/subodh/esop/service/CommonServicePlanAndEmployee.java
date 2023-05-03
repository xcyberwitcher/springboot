package com.subodh.esop.service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subodh.esop.dto.Plandto;
import com.subodh.esop.dto.Vestingdto;
import com.subodh.esop.entity.Employee;
import com.subodh.esop.entity.LockIn;
import com.subodh.esop.entity.Plan;
import com.subodh.esop.repository.EmployeeRepository;
import com.subodh.esop.repository.LockInRepository;
import com.subodh.esop.repository.PlanRepository;
@Service
public class CommonServicePlanAndEmployee {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	PlanRepository planRepository;
	@Autowired
	LockInRepository lockInRepository;
	public void saveEmployeeDetails(Employee employee)
	{	
		employeeRepository.save(employee);
	}	
	public void preparePlan(Plandto plandto)
	{
		
		Plan plan= new Plan();
		plan.setYear(plandto.getYear());
		plan.setStartDate(plandto.getStartDate());
		plan.setActualEndDate(plandto.getActualEndDate());
		plan.setCurrentPlanYear(plandto.isCurrentPlanYear());
		plan.setVestingFactor(null);
		plan.setMonetizationDate(null);
		plan.setForeMarketValue(null);
		
		planRepository.save(plan);	
	}
	public Plan findByPlanByPlanYear(String year)
	{
		
		return planRepository.findByPlanByPlanYear(year);
		
	}
	public Plan findByPlanId(Long id)
	{
		
		return planRepository.findById(id).get();
		
	}
	public void startManetization(Vestingdto vestingdto)
	{
		
	      Plan plan=findByPlanByPlanYear(vestingdto.getYear());
	      plan.setVestingFactor(vestingdto.getVestingFactor());
	      plan.setMonetizationDate(vestingdto.getMonetizationDate());
	      plan.setForeMarketValue(vestingdto.getFareMarketValue());
	      planRepository.save(plan);	
	}
	public void saveLockInDetails(LockIn lock)
	{	
		lockInRepository.save(lock);
		
	}
	public void updateLockStatus(String employeeNumber)
	{
		
		
		LockIn lockIn = lockInRepository.findByLockInByEmployeeNumber(employeeNumber);
		if(lockIn.getLockStatus().equals("Locked"))
		{
			lockIn.setLockStatus("Open");
			lockIn.setCreatedDate(new Date());
			lockIn.setModifiedDate(new Date());
			lockInRepository.save(lockIn);
			
		}
		else 
		{
			lockIn.setLockStatus("Locked");
			lockIn.setCreatedDate(new Date());
			lockIn.setModifiedDate(new Date());
			lockInRepository.save(lockIn);
			
		}
	}
	
	
	
}

