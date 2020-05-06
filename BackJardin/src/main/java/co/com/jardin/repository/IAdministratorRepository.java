package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.AdministratorEntity;

@Repository
public interface IAdministratorRepository extends JpaRepository<AdministratorEntity, Long> {

}
