package co.com.jardin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jardin.entity.NoteEntity;
import co.com.jardin.servie.INoteService;

@RestController
@RequestMapping("/note")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

	private INoteService iNoteService;

	@Autowired
	public NoteController(INoteService iNoteService) {
		this.iNoteService = iNoteService;
	}
	
	@GetMapping("/note")
	public ResponseEntity<?> findAll(){
		List<NoteEntity> noteList = iNoteService.findAll();
		return new ResponseEntity<>(noteList, HttpStatus.OK);
	}

	@GetMapping("/note/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		NoteEntity note = iNoteService.findById(id);
		if(note != null) {
			return new ResponseEntity<>(note, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@PostMapping("/note")
	private ResponseEntity<?> save(@RequestBody NoteEntity noteEntity){
		iNoteService.save(noteEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/note/{id}")
	private ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody NoteEntity noteEntity){
		NoteEntity note = iNoteService.findById(id);
		if(note != null) {
			note.setNote(noteEntity.getNote());
			note.setObservation(noteEntity.getObservation());
			note.setMatterId(noteEntity.getMatterId());
			note.setPeriodoId(noteEntity.getPeriodoId());
			iNoteService.save(noteEntity);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@DeleteMapping("/note/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		iNoteService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
