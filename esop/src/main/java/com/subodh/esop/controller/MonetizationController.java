package com.subodh.esop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.subodh.esop.constant.AppConst;
import com.subodh.esop.entity.Exercise;
import com.subodh.esop.service.MonetizationService;
@RestController
@RequestMapping(value=AppConst.MONETIZATION_CONTROLLER)
public class MonetizationController {

	@Autowired
	MonetizationService monetizationService;
	@PostMapping(value=AppConst.SAVE_EXERCISE_OPTION)
	public void saveExerciseOption(@RequestBody Exercise exercise)
	{
	
		monetizationService.saveExerciseOption(exercise);
		
	}
	
}

