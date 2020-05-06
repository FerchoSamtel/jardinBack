package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.EstudentEntity;

@Repository
public interface IStudentRepository extends JpaRepository<EstudentEntity, Long> {

}
