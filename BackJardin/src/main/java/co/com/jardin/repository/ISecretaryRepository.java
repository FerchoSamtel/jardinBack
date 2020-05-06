package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.Secretaryentity;

@Repository
public interface ISecretaryRepository extends JpaRepository<Secretaryentity, Long> {

}
