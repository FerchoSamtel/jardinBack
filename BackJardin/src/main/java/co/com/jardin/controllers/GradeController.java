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

import co.com.jardin.entity.GradeEntity;
import co.com.jardin.servie.IGradeService;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = "http://localhost:4200")
public class GradeController {

	private IGradeService gradeService;

	@Autowired
	public GradeController(IGradeService gradeService) {
		this.gradeService = gradeService;
	}
	
	@GetMapping("/grade")
	public ResponseEntity<?> findAll(){
		List<GradeEntity> gradeList = gradeService.findAll();
		return new ResponseEntity<>(gradeList, HttpStatus.OK);
	}
	
	@GetMapping("/grade/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		GradeEntity grade = gradeService.findById(id);
		return new ResponseEntity<>(grade, HttpStatus.OK);
	}
	
	@PostMapping("/grade")
	public ResponseEntity<?> save(@RequestBody GradeEntity gradeEntity){
		gradeService.save(gradeEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/grade/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody GradeEntity gradeEntity){
		GradeEntity gradeDb = gradeService.findById(id);
		if(gradeDb != null) {
			gradeDb.setName(gradeEntity.getName());
			gradeDb.setGroupId(gradeEntity.getGroupId());
			gradeService.save(gradeDb);			
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@DeleteMapping("/grade/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		gradeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
