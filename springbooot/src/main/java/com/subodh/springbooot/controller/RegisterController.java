package com.subodh.springbooot.controller;
import java.util.List;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.subodh.springbooot.constant.AppConstant;
import com.subodh.springbooot.dto.RegisterDto;
import com.subodh.springbooot.entity.RegisterEntity;
import com.subodh.springbooot.service.MysqlServiceImpl;
import com.subodh.springbooot.service.RegisterService;

@RestController
@RequestMapping(value = AppConstant.FORWARDS_SLASH)
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	private MysqlServiceImpl mysqlService;
	@Value("${logging.file.name}")
	private String loggerPath;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);
	
	 
	@PostMapping(value = AppConstant.SAVE_REGISTER_DETAILS)
     public void saveRegisterDetails(@RequestBody RegisterEntity register) {
 	    LOGGER.info("inside saveRegisterDetails() of RegisterController register{}:"+register);
		registerService.saveRegisterDetails(register);
     }
	@GetMapping(value=AppConstant.GET_ALL_REGISTER_DETAILS)
	public @ResponseBody List<RegisterEntity> getAllRegisterDetails(){
		return registerService.getAllRegisterDetails();
	}
	@GetMapping(value=AppConstant.GET_ALL_RECORDS)
	public @ResponseBody List<RegisterEntity>getAllRegisterRecords(){
		return mysqlService.getAllRegisterRecords();
	}
	@GetMapping(value=AppConstant.FIND_BY_ID)
	public @ResponseBody RegisterEntity findById(Long id){
		return registerService.findById(id);
	}
	@GetMapping(value=AppConstant.FIND_BY_NAME)
	public @ResponseBody RegisterEntity findByName(@RequestHeader String name){
		LOGGER.info("inside findByName() of RegisterController register{}:" +name);
		LOGGER.info("loggerPath:" +loggerPath);
		return registerService.findByName(name);
	}
	@GetMapping(value=AppConstant.FIND_BY_NAME_AND_PINCODE)
	public @ResponseBody RegisterEntity findByNameAndPincode(@RequestHeader String name,@RequestHeader String pincode){
		return registerService.findByNameAndPinCode(name,pincode);
	}
	@GetMapping(value=AppConstant.FIND_BY_PINCODE)
	public @ResponseBody List<RegisterEntity> findByPincode(@RequestHeader String pincode){
		return registerService.findByPinCode(pincode);
	}
	@GetMapping(value=AppConstant.FIND_BY_NAME_OR_PINCODE)
	public @ResponseBody List<RegisterEntity> findByNameOrPincode(@RequestHeader String name,@RequestHeader String pincode){
		return registerService.findByNameOrPinCode(name,pincode);
	}
	@GetMapping(value=AppConstant.DELETE_BY_ID)
	public @ResponseBody void deleteById(Long id){
		 registerService.deleteById(id);
	}
	
	@PostMapping(value = AppConstant.SAVE_ALL_REGISTER_DETAILS)
    public void saveAllRegisterDetails(@RequestBody List <RegisterEntity> list) {
		registerService.saveAllRegisterDetails(list);
    }
	
	@PutMapping(value = AppConstant.UPDATE_USER)
	public void update(@RequestBody List<RegisterDto> registerDto) {
		registerService.update(registerDto);
	}
	
}
