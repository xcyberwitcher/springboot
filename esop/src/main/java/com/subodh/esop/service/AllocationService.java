package com.subodh.esop.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.subodh.esop.dto.Optiondto;
import com.subodh.esop.entity.Allocation;
import com.subodh.esop.entity.Grant;
import com.subodh.esop.entity.Plan;
import com.subodh.esop.entity.VestedOption;
import com.subodh.esop.jdbcTemplateModel.OptionDtoRowMapper;
import com.subodh.esop.repository.AllocationRepository;
import com.subodh.esop.repository.GrantRepository;
import com.subodh.esop.repository.VestedOptionRepository;


/**
 * @author SUBODH KUMAR
 * 
 * Class:  AllocationService
 */
@Service
public class AllocationService { 
	
	@Autowired
	GrantRepository grantRepository;
	
	@Autowired
	AllocationRepository allocationRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	MonetizationService monetizationService;
	
	@Autowired
	VestedOptionRepository vestedOptionRepository; 
	
	
 
	
	

	/** Method Name: initiateAllocation
	 * @returnList<Allocation> 
	 */
	
	public List<Allocation> initiateAllocation()
	{
		
		List<Grant> grantlist=grantRepository.findBygrantStatusAndallocatinStatus("granted", false);
		
		List<Allocation> allocationlist= new ArrayList<>();
		
		Calendar now = Calendar.getInstance();
		
		
		  String[] array = {"A6", "A7", "A8", "A9", "A10"};
		  List<String> list = Arrays.asList(array);
		  
		  int count=1;  
		
		for(Grant grant:grantlist)
		{
			
			
			if(list.contains(grant.getBrand()))
			{ 
				for(int i=1;i<=5;i++)
				{
					Allocation allocation = new Allocation();
					allocation.setGrant(grant);
					allocation.setAllocationDate(""+now.get(Calendar.DATE)+"-"+now.get(Calendar.MONTH)+"-"+(now.get(Calendar.YEAR)+count));
					allocation.setStatus("pending");
					allocation.setAllocationNumber((double) (grant.getNumberOfGrante()/5));
					allocation.setAllocationYear(""+ (now.get(Calendar.YEAR)+ count++));
					allocationlist.add(allocation);
				}
				count=1;
			}
			 
			else 
			{
				Allocation allocation = new Allocation();
				allocation.setGrant(grant);
				allocation.setAllocationDate(""+now.get(Calendar.DATE)+"-"+now.get(Calendar.MONTH)+"-"+(now.get(Calendar.YEAR)));
				allocation.setStatus("pending");
				allocation.setAllocationNumber((double) (grant.getNumberOfGrante()));
				allocation.setAllocationYear(""+(now.get(Calendar.YEAR)+1));
				allocationlist.add(allocation);
				
			}
			grant.setAllocatinStatus(true);
			grantRepository.save(grant);
			
		}
		
		allocationRepository.saveAll(allocationlist);
		return allocationlist;
		
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Method : findAllocatedAllocationSumByPlan in AllocationService
	 * @param planyear
	 * @return List<Optiondto>
	 */
	public List<Optiondto> findAllocatedAllocationSumByPlan(String planyear)
	{
		
		String sql="""
				select esopdb.plan_info.id as plan_id, esopdb.grant_info.grant_id, esopdb.grant_info.employee_number, sum(esopdb.allocation_info.allocation_number)
				from esopdb.plan_info left join esopdb.grant_info
				on esopdb.grant_info.plan_id=esopdb.plan_info.id
				left join esopdb.allocation_info
				on esopdb.grant_info.id=esopdb.allocation_info.grant_id
				where esopdb.allocation_info.status ="APPROVED" and esopdb.plan_info.year="2021" group by esopdb.grant_info.grant_id; """;
		
		return jdbcTemplate.query(sql, new OptionDtoRowMapper());
		
	}
	
	
	
	
	
	
	
	/**
	 *  Method : findAllocationById in AllocationService
	 * @param id
	 * @return Allocation
	 */
	public Allocation findAllocationById(Long id)
	
	{	
		return allocationRepository.findById(id).get();	
		
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Method : updateAllocationStatus in AllocationService
	 * @param allocationIdList
	 */
	public void  updateAllocationStatus(List<Long> allocationIdList)
	{
		
		List<Allocation> allocationlist= new ArrayList();
		
		for(Long longid:allocationIdList)
		{
			
			Allocation allocation= findAllocationById(longid);
			allocation.setStatus("APPROVED");
			
			Grant grant=allocation.getGrant();
			Plan plan=grant.getPlan();
			
			if(monetizationService.isManetizationStarted(plan.getId()))
				{
					VestedOption vestedOption= monetizationService.findBygrantId(grant.getGrantId());
					
					if(vestedOption != null)
					{
						vestedOption.setVestedOption(vestedOption.getVestedOption()+( plan.getVestingFactor()*allocation.getAllocationNumber()));
						vestedOptionRepository.save(vestedOption);
						
					}
					else
					{
						
						VestedOption vestedOption2= new VestedOption();
						vestedOption2.setCreatedDate(new Date());
						vestedOption2.setMotifiedDate(new Date());
						vestedOption2.setGrantId(grant.getGrantId());
						vestedOption2.setVestedOption(plan.getVestingFactor()*allocation.getAllocationNumber());
						vestedOptionRepository.save(vestedOption2);
						
					}
					
               	}
			  
			        allocationRepository.save(allocation);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Method : findAllocationByGrantId in AllocationService
	 * @param grant
	 * @return Allocation
	 */
	public Allocation findAllocationByGrantId(Grant grant)
	{
		
		return allocationRepository.findAllocationByGrantId(grant);
		
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * Method : ScheduledThread in AllocationService
	 */
	@Scheduled(cron = "0 */2 * ? * *")
	public void ScheduledThread()
	{
		
		Thread thread= new Thread()
				{
			
			@Override
			public void run() {
				System.out.println("Thread is Excuting");
				System.out.println("Scheduler is Working");
				initiateAllocation();
			}
				};
		   thread.start();
		
	}
	
	

}
