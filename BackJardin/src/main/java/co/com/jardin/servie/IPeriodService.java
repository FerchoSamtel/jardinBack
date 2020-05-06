package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.PeriodEntity;

public interface IPeriodService {

	public List<PeriodEntity> findAll();
	
	public PeriodEntity findById(Long id);
	
	public PeriodEntity save(PeriodEntity periodEntity);
	
	public void deleteById(Long id);
}
