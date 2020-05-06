package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.TeacherEntity;

@Repository
public interface ITeacherRepository extends JpaRepository<TeacherEntity, Long> {

}
