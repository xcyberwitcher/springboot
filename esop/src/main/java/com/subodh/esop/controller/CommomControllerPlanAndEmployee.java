package com.subodh.esop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.subodh.esop.constant.AppConst;
import com.subodh.esop.dto.Plandto;
import com.subodh.esop.dto.Vestingdto;
import com.subodh.esop.entity.Employee;
import com.subodh.esop.entity.LockIn;
import com.subodh.esop.entity.Plan;
import com.subodh.esop.service.CommonServicePlanAndEmployee;
import com.subodh.esop.service.MonetizationService;
@RestController
@RequestMapping(value=AppConst.COMMON_CONTROLLER_PLAN_AND_EMPLOYEE)
public class CommomControllerPlanAndEmployee {
	
	@Autowired
	CommonServicePlanAndEmployee commonServicePlanAndEmployee;
	@Autowired
	MonetizationService monetizationService;
	@PostMapping(value=AppConst.SAVE_EMPLOYEE_DETAILS)
	public void saveEmployeeDetails( @RequestBody Employee employee)
	{
		
		commonServicePlanAndEmployee.saveEmployeeDetails(employee);
	}
	@PostMapping(value=AppConst.PREPARE_PLAN)
	public void preparePlan( @RequestBody Plandto plandto)
	{
		commonServicePlanAndEmployee.preparePlan(plandto);
	}
	@GetMapping(value=AppConst.FIND_BY_PLAN_BY_PLANYEAR)
	public @ResponseBody Plan findByPlanByPlanYear( String year)
	{
		
		return commonServicePlanAndEmployee.findByPlanByPlanYear(year);
	}
		
	@GetMapping(value=AppConst.FIND_BY_PLAN_ID)
	public @ResponseBody Plan findByPlanId(Long id)
	{
		return commonServicePlanAndEmployee.findByPlanId(id);
		
	}
	
	
	@PutMapping(value=AppConst.START_MANETIZATION)
	public void startManetization(@RequestBody Vestingdto vestingdto)
	{
	
		commonServicePlanAndEmployee.startManetization(vestingdto);
	}
	
	@PostMapping(value=AppConst.PREPARE_VESTED_OPTION)
	public void prepareVestedOption(@RequestBody Vestingdto vestingdto )
	{
		monetizationService.prepareVestedOption(vestingdto);
		
	}
	
	@GetMapping(value=AppConst.ISMANETIZATION_STARTED) 
	public @ResponseBody void isManetizationStarted( Long planId)
	{
		monetizationService.isManetizationStarted(planId);
	}
	
	
	
	
	@PostMapping(value=AppConst.SAVE_LOCKIN_DETAILS)
	public void saveLockInDetails(@RequestBody LockIn lock)
	{
	
		commonServicePlanAndEmployee.saveLockInDetails(lock);
	}
	
	
	
    @PutMapping(value=AppConst.UPDATE_LOCK_STATUC)
	public void updateLockStatus(@RequestHeader("employeeNumber") String employeeNumber)
	{
	
		commonServicePlanAndEmployee.updateLockStatus(employeeNumber);
	}
}

