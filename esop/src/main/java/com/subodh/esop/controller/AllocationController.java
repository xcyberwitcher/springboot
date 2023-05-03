package com.subodh.esop.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.subodh.esop.constant.AppConst;
import com.subodh.esop.entity.Allocation;
import com.subodh.esop.service.AllocationService;
@RestController
@RequestMapping(value=AppConst.ALLOCATION_CONTROLLER)
public class AllocationController {
	@Autowired
	AllocationService allocationService;
	private static final Logger LOGGER=LoggerFactory.getLogger(AllocationController.class);
	@GetMapping (value=AppConst.INITIATE_ALLOCATION)
	public @ResponseBody List<Allocation> initiateAllocation()
	{
		
		try {
			
			LOGGER.info("inside AllocationController initiateAllocation() method has been Excuted");
			
		} catch (Exception e) {
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
			
		}
		
		return allocationService.initiateAllocation();
	}
	
	@GetMapping(value=AppConst.FIND_BY_ALLOCATION_BY_ID)
    public  @ResponseBody Allocation findAllocationById(@RequestHeader("id") Long id)
	
	{
    	try {
			
    		LOGGER.info("inside AllocationController findAllocationById() method has been Excuted");
    		
		} catch (Exception e) {
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
		}
    	
    	return allocationService.findAllocationById(id);
	}
	
	@PostMapping(value=AppConst.UPDATE_ALLOCATION_STATUS)
	public void  updateAllocationStatus(@RequestBody List<Long> allocationIdList)
	{
		
		 try {
			 
			allocationService.updateAllocationStatus(allocationIdList);
			LOGGER.info("inside AllocationController updateAllocationStatus() method has been Excuted");
			
		} catch (Exception e) {
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
		}	
	}
	@PostMapping(value=AppConst.APPROVE_ALLOCATION)
	public void approveAllocation( @RequestBody List<Long> allocationIdList)
	{
		
		allocationService.updateAllocationStatus(allocationIdList);
	}
}

