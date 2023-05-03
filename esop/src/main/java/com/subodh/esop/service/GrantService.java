 package com.subodh.esop.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subodh.esop.dto.Grantdto;
import com.subodh.esop.entity.Grant;
import com.subodh.esop.entity.Plan;
import com.subodh.esop.repository.GrantRepository;
import com.subodh.esop.repository.LockInRepository;
@Service
public class GrantService {

	@Autowired
	GrantRepository grantRepository;
	
	@Autowired
	AllocationService allocationService;
	
	@Autowired
	CommonServicePlanAndEmployee CommonServicePlanAndEmployee;
	
	@Autowired
	LockInRepository lockInRepository;
    public void processUploadGrante(List<Grantdto> grantdto)
     {
    	 List<Grant> grantlist=prepareGrants(grantdto);
    	 grantRepository.saveAll(grantlist);
    	 
     }
    private List<Grant> prepareGrants(List<Grantdto> grantdto)
     {
    	 
    	 
    	 List<Grant> grant= new ArrayList<Grant> ();
    
	     
	     for(Grantdto grantdtol:grantdto)
	     {
	    	 Grant grantlist= new Grant();
	    	 
	    	 Plan plan=CommonServicePlanAndEmployee.findByPlanId(grantdtol.getPlanid());
	    	 
	    	 grantlist.setPlan(plan);
	    	 grantlist.setGrantId(grantdtol.getGrantId());
	    	 grantlist.setEmployeeNumber(grantdtol.getEmployeeNumber());
	    	 grantlist.setBrand(grantdtol.getBand());
	    	 grantlist.setNumberOfGrante(grantdtol.getNumberofGrante());
	    	 grantlist.setGrantPrice(grantdtol.getGrantePrice());
	    	 grantlist.setGrantStatus("granted");
	    	 grantlist.setAcceptedDate(new Date());
	    	 grantlist.setGrantedDate(new Date());
	    	 grantlist.setAccepted(true);
	    	 grantlist.setAllocatinStatus(false);
	    	 grant.add(grantlist);	    	
	     }
	     
    	  for(Grant list:grant)System.out.println(list);
    	  return grant; 
     }
     
    public void approveGrant(List<String> grantIdList)
	{
	   
       for(String id:grantIdList)
       {
    	   
    	   Grant grant=findBygrantIdDetails(id);
    	   grant.setGrantStatus("Granted");
    	   grant.setAllocatinStatus(false);
    	   grant.setNumberOfGrante(500L);
    	   grantRepository.save(grant);
       
       }
    	
	}
    public Grant findBygrantIdDetails(String grantId)
	{
		
		Grant grant= grantRepository.findBygrantId(grantId);
		return grant;
	}
    
    public void acceptGrant(String grantId)
	{
	
    	Grant grant= grantRepository.findBygrantId(grantId);
    	grant.setAccepted(true);
    	grantRepository.save(grant);
    	
	}
    
    public List<Grant> findByGrantStatusAndAllocationStatusDetails(String grantStatus,boolean allocatinStatus)
    {
    	
    	return grantRepository.findBygrantStatusAndallocatinStatus(grantStatus, allocatinStatus);
    	
    }
     
    public List<Grant> findByGrantsUsingPlanId(Plan plan)
    {
    	return grantRepository.findByGrantsUsingPlanId(plan);
    	
    }
    
    
}
			