package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.MatterEntity;
import co.com.jardin.repository.IMatterRespository;
import co.com.jardin.servie.IMatterService;

@Service
public class MatterServiceImpl implements IMatterService {

	private IMatterRespository matterRepository;
	
	@Autowired
	public MatterServiceImpl(IMatterRespository matterRepository) {
		this.matterRepository = matterRepository;
	}

	@Override
	public List<MatterEntity> findAll() {
		return matterRepository.findAll();
	}

	@Override
	public MatterEntity findById(Long id) {
		return matterRepository.findById(id).orElse(null);
	}

	@Override
	public MatterEntity save(MatterEntity matterEntity) {
		return matterRepository.save(matterEntity);
	}

	@Override
	public void deleteById(Long id) {
		matterRepository.deleteById(id);
	}

}
