package com.subodh.hospital.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subodh.hospital.controller.TestController;
import com.subodh.hospital.entity.TestEntity;
import com.subodh.hospital.repository.TestRepository;
@Service
public class TestService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	@Autowired
    private TestRepository testRepository;
	
	public void saveTestDetails(TestEntity test) { 
	 	 LOGGER.info("inside saveTestDetails() of TestService test{}:"+test);
	 	 testRepository.save(test);
	 }
	
	public List<TestEntity> getAllTestDetails(){
		 return testRepository.findAll();
	 }
	
	public TestEntity findById(Long id) {
	 	 LOGGER.info("inside findById() of TestService id{}:"+id);
		 return testRepository.findById(id).get();
	 }
}
