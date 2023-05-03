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
import com.subodh.esop.dto.Grantdto;
import com.subodh.esop.entity.Grant;
import com.subodh.esop.entity.Plan;
import com.subodh.esop.service.GrantService;
@RestController
@RequestMapping(value=AppConst.GRANT_CONTROLLER)
public class GrantController {	
	@Autowired
	GrantService grantService;
	private static final Logger LOGGER=LoggerFactory.getLogger(GrantController.class);
	
	@PostMapping(value=AppConst.UPLOAD_GRANTE)
	public void uploadGrante(@RequestBody List<Grantdto> grantdto)
	{
		
		try {
			
			grantService.processUploadGrante(grantdto);
			LOGGER.info("inside GrantController uploadGrante() method has been Excuted"+grantdto);
			
		    }
		
		catch (Exception e)
			{
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
			
			}
		
	}
	
	@PostMapping(value=AppConst.APPROVE_GRANT)
	public void approveGrant( @RequestBody List<String> grantIdList)
	{
		try {
			
			grantService.approveGrant(grantIdList);
			LOGGER.info("inside GrantController approveGrant() method has been Excuted"+grantIdList);
			
		} 
		catch (Exception e) {
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
			
		}
	}
	
	@GetMapping(value=AppConst.FIND_BY_ID)
	public @ResponseBody Grant  findBygrantId( @RequestHeader("grantId") String grantId)
	{
		
		try {
			
			
			LOGGER.info("inside GrantController findBygrantId() method has been Excuted"+grantId);
			
		} catch (Exception e) {
			
			LOGGER.error("exception Occured "+ e.getStackTrace());
			
		}
		
		return grantService.findBygrantIdDetails(grantId);
	}
	
	@PostMapping(value=AppConst.ACCEPT_GRANT)
	public void acceptGrant(@RequestHeader("grandId")String grantId)
	{
		try {
			
			grantService.acceptGrant(grantId);
			LOGGER.info("inside GrantController acceptGrant() method has been Excuted"+grantId);
			
			
		} catch (Exception e) {
			
		}
	}

	@GetMapping(value=AppConst.FINDBY_GRANTSTATUS_ALLOCATIONSATUS_DETAILS)
	public @ResponseBody List<Grant>  findByGrantStatusAndAllocationStatusDetails(String grantStatus,boolean allocatinStatus)
	{  
	 
		return grantService.findByGrantStatusAndAllocationStatusDetails(grantStatus, allocatinStatus);
	}
	@GetMapping(value=AppConst.FIND_BY_GRANTS_USING_PLANID)
	public @ResponseBody List<Grant> findByGrantsUsingPlanId(Plan plan)
    {
	
		return grantService.findByGrantsUsingPlanId(plan);
	    	
	}
}

