package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.GroupEntity;

@Repository
public interface IGroupRepository extends JpaRepository<GroupEntity, Long> {

}
