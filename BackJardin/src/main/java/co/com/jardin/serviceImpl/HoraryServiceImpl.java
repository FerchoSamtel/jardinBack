package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.HoraryEntity;
import co.com.jardin.repository.IHoraryRepository;
import co.com.jardin.servie.IHoraryServie;

@Service
public class HoraryServiceImpl implements IHoraryServie {

	private IHoraryRepository horaryRepository;
	
	@Autowired
	public HoraryServiceImpl(IHoraryRepository horaryRepository) {
		this.horaryRepository = horaryRepository;
	}

	@Override
	public List<HoraryEntity> findAll() {
		return horaryRepository.findAll();
	}

	@Override
	public HoraryEntity findById(Long id) {
		return horaryRepository.findById(id).orElse(null);
	}

	@Override
	public HoraryEntity save(HoraryEntity horaryEntity) {
		return horaryRepository.save(horaryEntity);
	}

	@Override
	public void deleteById(Long id) {
		horaryRepository.deleteById(id);
	}

}
