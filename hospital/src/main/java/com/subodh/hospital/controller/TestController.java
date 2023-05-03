package com.subodh.hospital.controller;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.subodh.hospital.constant.AppConstatnt;
import com.subodh.hospital.entity.TestEntity;
import com.subodh.hospital.service.TestService;
@RestController
@RequestMapping(value = AppConstatnt.FORWARDS_SLASH)
public class TestController {
	@Autowired
	private TestService testService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Value("${logging.file.name}")
	private String loggerPath;
	
	@PostMapping(value = AppConstatnt.Test_SAVE_Details)
    public void saveTestDetails(@RequestBody TestEntity test) {
	    LOGGER.info("inside saveTestDetails() of TestController test{}:"+test);
		testService.saveTestDetails(test);
    }
	@GetMapping(value=AppConstatnt.GET_ALL_TEST_DETAILS)
	public @ResponseBody List<TestEntity> getAllTestDetails(){	
		return testService.getAllTestDetails();
	}
	@GetMapping(value=AppConstatnt.GET_BY_TEST_ID)
	public @ResponseBody TestEntity findById(Long id){
		return testService.findById(id);
	}
}
