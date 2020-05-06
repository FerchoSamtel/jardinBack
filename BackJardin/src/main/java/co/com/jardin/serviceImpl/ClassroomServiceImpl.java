package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.ClassroomEntity;
import co.com.jardin.repository.IClassroomRepository;
import co.com.jardin.servie.IClassroomService;

@Service
public class ClassroomServiceImpl implements IClassroomService {

	private IClassroomRepository classroomRepository;
	
	@Autowired
	public ClassroomServiceImpl(IClassroomRepository classroomRepository) {
		this.classroomRepository = classroomRepository;
	}

	@Override
	public List<ClassroomEntity> findAll() {
		return classroomRepository.findAll();
	}

	@Override
	public ClassroomEntity findById(Long id) {
		return classroomRepository.findById(id).orElse(null);
	}

	@Override
	public ClassroomEntity save(ClassroomEntity classroomEntity) {
		return classroomRepository.save(classroomEntity);
	}

	@Override
	public void deleteById(Long id) {
		classroomRepository.deleteById(id);
	}

}
