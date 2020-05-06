package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.Area;

public interface IAreaService {

	public List<Area> findAll();
	
	public Area findById(Long id);
	
	public Area save(Area area);
	
	public void deleteById(Long id);
}
