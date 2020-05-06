package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.Area;
import co.com.jardin.repository.IAreaRepository;
import co.com.jardin.servie.IAreaService;

@Service
public class AreaServiceImpl implements IAreaService {

	private IAreaRepository areaRepository;
	
	@Autowired
	public AreaServiceImpl(IAreaRepository areaRepository) {
		this.areaRepository = areaRepository;
	}

	@Override
	public List<Area> findAll() {
		return areaRepository.findAll();
	}

	@Override
	public Area findById(Long id) {
		return areaRepository.findById(id).orElse(null);
	}

	@Override
	public Area save(Area area) {
		return areaRepository.save(area);
	}

	@Override
	public void deleteById(Long id) {
		areaRepository.deleteById(id);
	}
}
