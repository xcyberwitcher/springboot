package com.subodh.intergrationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.subodh.intergrationservice.contant.IntegrationConstant;
import com.subodh.intergrationservice.dto.EmailDto;
import com.subodh.intergrationservice.service.EmailService;

@RestController
@RequestMapping(value = IntegrationConstant.FORWARDS_SLASH)
public class EmailController {
	@Autowired
	private EmailService emailService;

    @PostMapping(value = IntegrationConstant.Send_Mail)
	public void ProcessMail(@RequestBody EmailDto dto) {
		emailService.SendMail(dto);
	}
 
    
	
}
