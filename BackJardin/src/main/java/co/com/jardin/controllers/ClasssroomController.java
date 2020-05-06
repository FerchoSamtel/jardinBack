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

import co.com.jardin.entity.ClassroomEntity;
import co.com.jardin.servie.IClassroomService;

@RestController
@RequestMapping("/classroom")
@CrossOrigin(origins = "http://localhost:4200")
public class ClasssroomController {

	private IClassroomService classroomService;

	@Autowired
	public ClasssroomController(IClassroomService classroomService) {
		this.classroomService = classroomService;
	}
	
	@GetMapping("/classroom")
	public ResponseEntity<?> findAll(){
		List<ClassroomEntity> classRoom = classroomService.findAll();
		return new ResponseEntity<>(classRoom, HttpStatus.OK);
	}
	
	@GetMapping("/classroom/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		ClassroomEntity classRoom = classroomService.findById(id);
		return new ResponseEntity<>(classRoom, HttpStatus.OK);
	}
	
	@PostMapping("/classroom")
	public ResponseEntity<?> save(@RequestBody ClassroomEntity classroomEntity){
		classroomService.save(classroomEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/classroom/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ClassroomEntity classroomEntity){
		ClassroomEntity classRoom = classroomService.findById(id);
		if(classRoom != null) {
			classRoom.setFloor(classroomEntity.getFloor());
			classRoom.setNumber(classroomEntity.getNumber());
			classroomService.save(classRoom);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@DeleteMapping("/classroom/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		classroomService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
