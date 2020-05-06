package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.HoraryEntity;

public interface IHoraryServie {

	public List<HoraryEntity> findAll();
	
	public HoraryEntity findById(Long id);
	
	public HoraryEntity save(HoraryEntity horaryEntity);
	
	public void deleteById(Long id);
}
