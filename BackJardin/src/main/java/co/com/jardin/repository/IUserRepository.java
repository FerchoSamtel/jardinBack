package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.jardin.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long>{

}
