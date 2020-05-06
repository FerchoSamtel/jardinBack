package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.TeacherEntity;

public interface ITeacherService {

	public List<TeacherEntity> findAll();
	
	public TeacherEntity findById(Long id);
	
	public TeacherEntity save(TeacherEntity entity);
	
	public void deleteById(Long id);
}
