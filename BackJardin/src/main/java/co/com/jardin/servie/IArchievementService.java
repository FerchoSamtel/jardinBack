package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.AchievementEntity;

public interface IArchievementService {

	public List<AchievementEntity> findAll();
	
	public AchievementEntity findById(Long id);
	
	public AchievementEntity save(AchievementEntity achievementEntity);
	
	public void deleteById(Long id);
}
