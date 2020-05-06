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

import co.com.jardin.entity.TeacherEntity;
import co.com.jardin.servie.ITeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

	private ITeacherService iTeacherService;

	@Autowired
	public TeacherController(ITeacherService iTeacherService) {
		this.iTeacherService = iTeacherService;
	}

	@GetMapping("/teacher")
	public ResponseEntity<?> findAll() {
		List<TeacherEntity> teacherList = iTeacherService.findAll();
		return new ResponseEntity<>(teacherList, HttpStatus.OK);
	}

	@GetMapping("/teacher/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		TeacherEntity teacher = iTeacherService.findById(id);
		if (teacher != null) {
			return new ResponseEntity<>(teacher, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/teacher")
	public ResponseEntity<?> save(@RequestBody TeacherEntity teacherEntity) {
		iTeacherService.save(teacherEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/teacher/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody TeacherEntity teacherEntity) {
		TeacherEntity teacher = iTeacherService.findById(id);
		if (teacher != null) {
			teacher.setCodigoId(teacherEntity.getCodigoId());
			teacher.setMatterId(teacherEntity.getMatterId());
			iTeacherService.save(teacher);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		iTeacherService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
