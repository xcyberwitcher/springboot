package com.subodh.esop.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subodh.esop.dto.Optiondto;
import com.subodh.esop.dto.Vestingdto;
import com.subodh.esop.entity.Exercise;
import com.subodh.esop.entity.Grant;
import com.subodh.esop.entity.LockIn;
import com.subodh.esop.entity.Plan;
import com.subodh.esop.entity.VestedOption;
import com.subodh.esop.repository.AllocationRepository;
import com.subodh.esop.repository.ExerciseRepository;
import com.subodh.esop.repository.LockInRepository;
import com.subodh.esop.repository.VestedOptionRepository;
@Service
public class MonetizationService {
	@Autowired
	AllocationService allocationService;
	@Autowired
	VestedOptionRepository vestedOptionRepository;
	@Autowired
	CommonServicePlanAndEmployee commonServicePlanAndEmployee;
	@Autowired
	GrantService grantService;
	@Autowired
	AllocationRepository allocationRepository;
	@Autowired
	ExerciseRepository exerciseRepository;
	@Autowired
	LockInRepository lockInRepository;
	
	public void prepareVestedOption(Vestingdto vestingdto )
	{
		
		List<Optiondto> optiondto= allocationService.findAllocatedAllocationSumByPlan(vestingdto.getYear());
		
		List<VestedOption> vestedOption= new ArrayList<>();
		
		for(Optiondto Optiondto1:optiondto)
		{
			
			VestedOption option= new VestedOption();
			option.setGrantId(Optiondto1.getGrantId());
			option.setVestedOption(Optiondto1.getAllocatedSum()*vestingdto.getVestingFactor());
			option.setCreatedDate(new Date());
			option.setMotifiedDate(new Date());
			
			vestedOption.add(option);				
		}
		
		vestedOptionRepository.saveAll(vestedOption);
	     	
		
	}
	
	public Boolean isManetizationStarted(Long plnaId)
	
	{
		
		Plan plan=commonServicePlanAndEmployee.findByPlanId(plnaId);
		
		if(plan.getMonetizationDate() != null) return true;
		return false;
		
	}
	
	public VestedOption findBygrantId(String grantId)
	{
		
		return vestedOptionRepository.findBygrantId(grantId);
	}
	public void saveExerciseOption(Exercise exercise)
	{
		
		
		Grant grant=grantService.findBygrantIdDetails(exercise.getGrantId());
		LockIn lockIn= lockInRepository.findByLockInByEmployeeNumber(grant.getEmployeeNumber());
		VestedOption vestedOption=vestedOptionRepository.findBygrantId(exercise.getGrantId());
		
		
		if(lockIn.getLockStatus().equals("Open"))
		{
				
			if( vestedOption.getVestedOption() >= exercise.getExerciseOption())
			{
				Exercise exercise2= new Exercise();
				exercise2.setStatus("pending");
				exercise2.setCreateddate(new Date());
				exercise2.setModifiedDate(new Date());
				exercise2.setExerciseOption(exercise.getExerciseOption());
				exerciseRepository.save(exercise2);
				
				if(exercise.getExerciseOption()>=exercise.getSoldOptions())
				{
					exercise2.setSoldOptions(exercise.getSoldOptions());
					exerciseRepository.save(exercise2);					
				}
				else System.out.println("You can only sold a maximum of"+exercise.getExerciseOption() );
			}	
			else System.out.println("You can only excercise a maximum of "+vestedOption.getVestedOption());
	
		}
		else System.out.println("Optional cannot be Exercised");
				
	}
}

