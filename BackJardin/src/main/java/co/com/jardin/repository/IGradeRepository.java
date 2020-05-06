package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.GradeEntity;

@Repository
public interface IGradeRepository extends JpaRepository<GradeEntity, Long> {

}
