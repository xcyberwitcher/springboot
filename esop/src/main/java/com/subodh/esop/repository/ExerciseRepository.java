package com.subodh.esop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subodh.esop.entity.Exercise;
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
