package com.subodh.carwale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subodh.carwale.entity.ModelEntity;
@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long>{

	
}
