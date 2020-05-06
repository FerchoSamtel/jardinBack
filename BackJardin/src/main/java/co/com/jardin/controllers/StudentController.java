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

import co.com.jardin.entity.EstudentEntity;
import co.com.jardin.servie.IStudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	private IStudentService iStudentService;

	@Autowired
	public StudentController(IStudentService iStudentService) {
		this.iStudentService = iStudentService;
	}

	@GetMapping("/student")
	public ResponseEntity<?> findAll() {
		List<EstudentEntity> studentList = iStudentService.findAll();
		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		EstudentEntity student = iStudentService.findById(id);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/student")
	public ResponseEntity<?> save(@RequestBody EstudentEntity estudentEntity) {
		iStudentService.save(estudentEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EstudentEntity estudentEntity) {
		EstudentEntity student = iStudentService.findById(id);
		if (student != null) {
			student.setName(estudentEntity.getName());
			student.setLastname(estudentEntity.getLastname());
			student.setBirthDate(estudentEntity.getBirthDate());
			student.setAttending(estudentEntity.getAttending());
			student.setDirection(estudentEntity.getDirection());
			student.setPhone(estudentEntity.getPhone());
			student.setEmail(estudentEntity.getPhone());
			student.setObservation(estudentEntity.getObservation());
			student.setSecretaryId(estudentEntity.getSecretaryId());
			iStudentService.save(student);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<?> delteById(@PathVariable("id") Long id){
		iStudentService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
