package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.EstudentEntity;
import co.com.jardin.repository.IStudentRepository;
import co.com.jardin.servie.IStudentService;

@Service
public class StudenteServiceImpl implements IStudentService {

	private IStudentRepository studentrepositoey;
	
	@Autowired
	public StudenteServiceImpl(IStudentRepository studentrepositoey) {
		this.studentrepositoey = studentrepositoey;
	}

	@Override
	public List<EstudentEntity> findAll() {
		return studentrepositoey.findAll();
	}

	@Override
	public EstudentEntity findById(Long id) {
		return studentrepositoey.findById(id).orElse(null);
	}

	@Override
	public EstudentEntity save(EstudentEntity studentEntity) {
		return studentrepositoey.save(studentEntity);
	}

	@Override
	public void deleteById(Long id) {
		studentrepositoey.deleteById(id);
	}

}
