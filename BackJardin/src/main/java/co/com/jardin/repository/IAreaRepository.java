package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.Area;
@Repository

public interface IAreaRepository extends JpaRepository<Area, Long> {

}
