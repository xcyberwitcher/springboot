package com.subodh.carwale.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subodh.carwale.entity.BrandEntity;
import com.subodh.carwale.repository.BrandRepository;
@Service
public class BrandService {
	@Autowired
    private BrandRepository brandRepository;
	 
	 public void saveBrandDetails(BrandEntity brand) { 
		 brandRepository.save(brand);
	 }
	 
	 public List<BrandEntity> getAllBrandDetails(){
		 return brandRepository.findAll();
	 }
}
