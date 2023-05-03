package com.subodh.esop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subodh.esop.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

