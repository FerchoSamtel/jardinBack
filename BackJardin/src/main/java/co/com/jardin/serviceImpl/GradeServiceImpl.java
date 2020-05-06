package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.GradeEntity;
import co.com.jardin.repository.IGradeRepository;
import co.com.jardin.servie.IGradeService;

@Service
public class GradeServiceImpl implements IGradeService {

	private IGradeRepository gradeRepository;
	
	@Autowired
	public GradeServiceImpl(IGradeRepository gradeRepository) {
		this.gradeRepository = gradeRepository;
	}

	@Override
	public List<GradeEntity> findAll() {
		return gradeRepository.findAll();
	}

	@Override
	public GradeEntity findById(Long id) {
		return gradeRepository.findById(id).orElse(null);
	}

	@Override
	public GradeEntity save(GradeEntity gradeEntity) {
		return gradeRepository.save(gradeEntity);
	}

	@Override
	public void deleteById(Long id) {
		gradeRepository.deleteById(id);
	}

}
