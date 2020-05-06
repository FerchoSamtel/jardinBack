package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.HoraryEntity;

@Repository
public interface IHoraryRepository extends JpaRepository<HoraryEntity, Long> {

}
