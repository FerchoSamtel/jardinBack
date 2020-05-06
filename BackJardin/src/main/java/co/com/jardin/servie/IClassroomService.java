package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.ClassroomEntity;

public interface IClassroomService {

	public List<ClassroomEntity> findAll();
	
	public ClassroomEntity findById(Long id);
	
	public ClassroomEntity save(ClassroomEntity classroomEntity);
	
	public void deleteById(Long id);
}
