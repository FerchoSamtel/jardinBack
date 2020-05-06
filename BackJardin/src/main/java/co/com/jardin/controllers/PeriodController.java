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

import co.com.jardin.entity.PeriodEntity;
import co.com.jardin.servie.IPeriodService;

@RestController
@RequestMapping("/period")
@CrossOrigin(origins = "http://localhost:4200")
public class PeriodController {

	private IPeriodService iPeriodService;

	@Autowired
	public PeriodController(IPeriodService iPeriodService) {
		this.iPeriodService = iPeriodService;
	}

	@GetMapping("/period")
	public ResponseEntity<?> findAll() {
		List<PeriodEntity> periodoList = iPeriodService.findAll();
		return new ResponseEntity<>(periodoList, HttpStatus.OK);
	}

	@GetMapping("/period/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		PeriodEntity periodo = iPeriodService.findById(id);
		if (periodo != null) {
			return new ResponseEntity<>(periodo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PostMapping("/period")
	public ResponseEntity<?> save(@RequestBody PeriodEntity periodEntity) {
		iPeriodService.save(periodEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/period/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PeriodEntity periodEntity) {
		PeriodEntity periodoDb = iPeriodService.findById(id);
		if (periodoDb != null) {
			periodoDb.setName(periodEntity.getName());
			iPeriodService.save(periodoDb);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/period/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		iPeriodService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
