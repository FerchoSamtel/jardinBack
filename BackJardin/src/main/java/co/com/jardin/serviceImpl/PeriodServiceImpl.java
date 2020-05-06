package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.PeriodEntity;
import co.com.jardin.repository.IPeriodRepository;
import co.com.jardin.servie.IPeriodService;

@Repository
public class PeriodServiceImpl implements IPeriodService {

	private IPeriodRepository periodoRepository;
	
	@Autowired
	public PeriodServiceImpl(IPeriodRepository periodoRepository) {
		this.periodoRepository = periodoRepository;
	}

	@Override
	public List<PeriodEntity> findAll() {
		return periodoRepository.findAll();
	}

	@Override
	public PeriodEntity findById(Long id) {
		return periodoRepository.findById(id).orElse(null);
	}

	@Override
	public PeriodEntity save(PeriodEntity periodEntity) {
		return periodoRepository.save(periodEntity);
	}

	@Override
	public void deleteById(Long id) {
		periodoRepository.deleteById(id);
	}

}
