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
import com.subodh.carwale.entity.BrandEntity;
import com.subodh.carwale.service.BrandService;
@RestController
@RequestMapping(value = AppConstant.FORWARDS_SLASH)
public class BrandController {
	@Autowired
	private BrandService brandService;
	@PostMapping(value = AppConstant.SAVE_BRAND_DETAILS)
     public void saveBrandDetails(@RequestBody BrandEntity brand) {
 		brandService.saveBrandDetails(brand);
     }
	@GetMapping(value=AppConstant.GET_ALL_BRAND_DETAILS)
	public @ResponseBody List<BrandEntity> getAllBrandDetails(){
		return brandService.getAllBrandDetails();
	}
	
}
