package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.MatterEntity;

public interface IMatterService {

	public List<MatterEntity> findAll();
	
	public MatterEntity findById(Long id);
	
	public MatterEntity save(MatterEntity matterEntity);
	
	public void deleteById(Long id);
}
