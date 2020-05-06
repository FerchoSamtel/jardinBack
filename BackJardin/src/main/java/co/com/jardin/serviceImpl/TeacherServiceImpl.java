package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.TeacherEntity;
import co.com.jardin.repository.ITeacherRepository;
import co.com.jardin.servie.ITeacherService;

@Service
public class TeacherServiceImpl implements ITeacherService {

	private ITeacherRepository teacherRepository;
	
	@Autowired
	public TeacherServiceImpl(ITeacherRepository teacherRepository) {
		this.teacherRepository = teacherRepository;
	}

	@Override
	public List<TeacherEntity> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public TeacherEntity findById(Long id) {
		return teacherRepository.findById(id).orElse(null);
	}

	@Override
	public TeacherEntity save(TeacherEntity entity){
		return teacherRepository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		teacherRepository.deleteById(id);
	}

}
