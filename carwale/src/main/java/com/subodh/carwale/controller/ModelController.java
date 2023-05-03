package com.subodh.carwale.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.subodh.carwale.constant.AppConstant;
import com.subodh.carwale.entity.ModelEntity;
import com.subodh.carwale.service.ModelService;
@RestController
@RequestMapping(value = AppConstant.FORWARDS_SLASH)
public class ModelController {
	@Autowired
	private ModelService modelService;
	@PostMapping(value = AppConstant.SAVE_MODEL_DETAILS)
    public void saveAllModelDetails(@RequestBody List <ModelEntity> modellist) {
		modelService.saveAllModelDetails(modellist);
    }
	@GetMapping(value=AppConstant.GET_ALL_MODEL_DETAILS)
	public @ResponseBody List<ModelEntity> getAllModelDetails(){
		return modelService.getAllModelDetails();
	}
//	@GetMapping(value=AppConstant.FIND_BY_BRANDID)
//	public @ResponseBody Optional<ModelEntity> findById(Long brandId){
//		return carService.findById(brandId);
//	}
}
