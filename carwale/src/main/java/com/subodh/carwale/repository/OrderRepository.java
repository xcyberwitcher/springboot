package com.subodh.carwale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subodh.carwale.entity.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails,Long>{
	
}
