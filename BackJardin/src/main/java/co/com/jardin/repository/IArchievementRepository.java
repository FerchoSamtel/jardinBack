package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.AchievementEntity;

@Repository
public interface IArchievementRepository extends JpaRepository<AchievementEntity, Long> {

}
