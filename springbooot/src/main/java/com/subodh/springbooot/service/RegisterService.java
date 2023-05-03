package com.subodh.springbooot.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.subodh.springbooot.controller.RegisterController;
import com.subodh.springbooot.dto.RegisterDto;
import com.subodh.springbooot.dto.ResponseStructure;
import com.subodh.springbooot.entity.RegisterEntity;
import com.subodh.springbooot.repository.RegisterRepository;
@Service
public class RegisterService {
	
	
     private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);

	
	 @Autowired
     private RegisterRepository registerRepository;
	 
	 public void saveRegisterDetails(RegisterEntity register) { 
	 	 LOGGER.info("inside saveRegisterDetails() of RegisterService register{}:"+register);
	 	 LOGGER.error("inside saveRegisterDetails() of RegisterService register{}:"+register);
	 	 LOGGER.debug("inside saveRegisterDetails() of RegisterService register{}:"+register);

	 	 registerRepository.save(register);
	 }
	 
	 public List<RegisterEntity> getAllRegisterDetails(){
		 return registerRepository.findAll();
	 }
	 public RegisterEntity findById(Long id) {
	 	 LOGGER.info("inside findById() of RegisterService id{}:"+id);
		 return registerRepository.findById(id).get();
	 }
	 public RegisterEntity findByName(String name) {
		 
			return registerRepository.findByName(name);
		}
	 public RegisterEntity findByNameAndPinCode(String name,String pincode) {
			return registerRepository.findByNameAndPincode(name,pincode);
		}
	 public List<RegisterEntity> findByNameOrPinCode(String name,String pincode) {
		 
			return registerRepository.findByNameOrPincode(name, pincode);
		}
	 public List<RegisterEntity> findByPinCode(String pincode) {
			return registerRepository.findByPincode(pincode);
		}
	 
	 public void deleteById(Long id) {
		 registerRepository.deleteById(id);
	 }
	 public void  saveAllRegisterDetails(List<RegisterEntity> list){
		 registerRepository.saveAll(list);
	 }
	 
	 public void update(List<RegisterDto> registerDto) {
		 registerDto.forEach(rd->{
			 RegisterEntity register = new RegisterEntity();
			 BeanUtils.copyProperties(rd, register);
			 registerRepository.save(register);
		 });
	 }
	 
//	 public ResponseStructure<RegisterEntity> getDetailsByName(String name){
//	   ResponseStructure<RegisterEntity>responseStructure =
//			   new ResponseStructure<RegisterEntity>();
//	   responseStructure.setData(registerRepository).getDetailsByName(name);
//	   responseStructure.setStatusCode(HttpStatus.FOUND.value());
//	   responseStructure.setMessage(" ");
//	   return responseStructure;
//	 }
	 
	 public ResponseStructure<RegisterEntity> getRegisterDetailsById(Long id){
		 LOGGER.info("inside getRegisterDetailsById() of registerService of registerEntity():"+id);
		 Optional<RegisterEntity>optional = registerRepository.findById(id);
		 ResponseStructure<RegisterEntity>responseStructure =
				   new ResponseStructure<RegisterEntity>(); 
		 
		 if(optional.isPresent()) {
			 responseStructure.setData(optional.get());
			 responseStructure.setStatusCode(HttpStatus.FOUND.value());
			 responseStructure.setMessage("message");
			 return responseStructure;
		 }
		 responseStructure.setData(null);
		 responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		 responseStructure.setMessage("not found message");
		 
		 return responseStructure; 
		 
	 }
	
	 
	 
}
