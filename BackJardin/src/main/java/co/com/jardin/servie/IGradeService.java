package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.GradeEntity;

public interface IGradeService {

	public List<GradeEntity> findAll();
	
	public GradeEntity findById(Long id);
	
	public GradeEntity save(GradeEntity gradeEntity);
	
	public void deleteById(Long id);
}
