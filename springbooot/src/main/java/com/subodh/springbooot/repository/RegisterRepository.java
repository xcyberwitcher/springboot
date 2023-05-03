package com.subodh.springbooot.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.subodh.springbooot.entity.RegisterEntity;
//@Repository
@EnableJpaRepositories
public interface RegisterRepository extends JpaRepository<RegisterEntity,Long>{  
//	 @Query("from RegisterEntity where name=:n")
//	RegisterEntity findByName(@Param("n")String name);
	 RegisterEntity findByName(String name);
	 
	 RegisterEntity findByNameAndPincode(String name,String pincode);

	List<RegisterEntity> findByNameOrPincode(String name, String pincode);
	
	List<RegisterEntity> findByPincode(String pincode);
	
}



