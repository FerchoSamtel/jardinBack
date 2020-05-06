package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.NoteEntity;

public interface INoteService {

	public List<NoteEntity> findAll();
	
	public NoteEntity findById(Long id);
	
	public NoteEntity save(NoteEntity noteEntity);
	
	public void deleteById(Long id);
}
