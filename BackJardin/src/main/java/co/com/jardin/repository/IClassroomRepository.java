package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.ClassroomEntity;

@Repository
public interface IClassroomRepository extends JpaRepository<ClassroomEntity, Long> {

}
