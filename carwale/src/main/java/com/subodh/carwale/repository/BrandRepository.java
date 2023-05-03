package com.subodh.carwale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subodh.carwale.entity.BrandEntity;
@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long>{
	
}
