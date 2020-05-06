package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.MatterEntity;

@Repository
public interface IMatterRespository extends JpaRepository<MatterEntity, Long> {

}
