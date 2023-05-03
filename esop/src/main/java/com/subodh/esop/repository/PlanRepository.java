package com.subodh.esop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.subodh.esop.entity.Plan;
@Repository
public interface PlanRepository extends JpaRepository<Plan,Long>{

	@Query("from Plan where year=:year")
	public Plan findByPlanByPlanYear(String year);
	
}

