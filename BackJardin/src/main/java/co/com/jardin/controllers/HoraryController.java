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

import co.com.jardin.entity.HoraryEntity;
import co.com.jardin.servie.IHoraryServie;

@RestController
@RequestMapping("/horary")
@CrossOrigin(origins = "http://localhost:4200")
public class HoraryController {

	private IHoraryServie horaryServie;

	@Autowired
	public HoraryController(IHoraryServie horaryServie) {
		this.horaryServie = horaryServie;
	}
	
	@GetMapping("/horary")
	public ResponseEntity<?> findAll(){
		List<HoraryEntity> horaryList = horaryServie.findAll();
		return new ResponseEntity<>(horaryList, HttpStatus.OK);
	}
	
	@GetMapping("/horary/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		HoraryEntity horary = horaryServie.findById(id);
		if(horary != null) {
			return new ResponseEntity<>(horary, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@PostMapping("/horary")
	public ResponseEntity<?> save(@RequestBody HoraryEntity horaryEntity){
		horaryServie.save(horaryEntity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/horary/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody HoraryEntity horaryEntity){
		HoraryEntity horary = horaryServie.findById(id);
		if(horary != null) {
			horary.setClassroomId(horaryEntity.getClassroomId());
			horary.setGradeId(horaryEntity.getGradeId());
			horary.setAdminId(horaryEntity.getAdminId());
			horary.setMatterId(horaryEntity.getMatterId());
			horary.setTeacherId(horaryEntity.getTeacherId());
			horaryServie.save(horary);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@DeleteMapping("/horary/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		horaryServie.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
