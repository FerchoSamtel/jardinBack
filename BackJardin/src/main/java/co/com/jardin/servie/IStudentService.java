package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.EstudentEntity;

public interface IStudentService {

	public List<EstudentEntity> findAll();
	
	public EstudentEntity findById(Long id);
	
	public EstudentEntity save(EstudentEntity studentEntity);
	
	public void deleteById(Long id);
}
