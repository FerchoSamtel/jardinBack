package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.AchievementEntity;
import co.com.jardin.repository.IArchievementRepository;
import co.com.jardin.servie.IArchievementService;

@Repository
public class AchievementServiceImpl implements IArchievementService {

	private IArchievementRepository achievementRpository;
	
	@Autowired
	public AchievementServiceImpl(IArchievementRepository achievementRpository) {
		this.achievementRpository = achievementRpository;
	}

	@Override
	public List<AchievementEntity> findAll() {
		return achievementRpository.findAll();
	}

	@Override
	public AchievementEntity findById(Long id) {
		return achievementRpository.findById(id).orElse(null);
	}

	@Override
	public AchievementEntity save(AchievementEntity achievementEntity) {
		return achievementRpository.save(achievementEntity);
	}

	@Override
	public void deleteById(Long id) {
		achievementRpository.deleteById(id);
	}

}
