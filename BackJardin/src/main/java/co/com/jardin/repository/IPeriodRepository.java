package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.PeriodEntity;

@Repository
public interface IPeriodRepository extends JpaRepository<PeriodEntity, Long> {

}
