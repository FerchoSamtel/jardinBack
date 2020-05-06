package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.NoteEntity;
import co.com.jardin.repository.INoteRepository;
import co.com.jardin.servie.INoteService;

@Service
public class NoteServiceImpl implements INoteService {

	private INoteRepository noteRepository;
	
	@Autowired
	public NoteServiceImpl(INoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

	@Override
	public List<NoteEntity> findAll() {
		return noteRepository.findAll();
	}

	@Override
	public NoteEntity findById(Long id) {
		return noteRepository.findById(id).orElse(null);
	}

	@Override
	public NoteEntity save(NoteEntity noteEntity) {		
		return noteRepository.save(noteEntity);
	}

	@Override
	public void deleteById(Long id) {
		noteRepository.deleteById(id);
	}

}
