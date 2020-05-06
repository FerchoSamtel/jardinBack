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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jardin.entity.AdministratorEntity;
import co.com.jardin.servie.IAdministratorService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministratorController {

	private IAdministratorService administratorService;

	@Autowired
	public AdministratorController(IAdministratorService administratorService) {
		this.administratorService = administratorService;
	}

	@GetMapping("/admin")
	public ResponseEntity<?> findAll() {
		List<AdministratorEntity> admin = administratorService.findAll();
		if (admin != null) {
			return new ResponseEntity<>(admin, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		AdministratorEntity admin = administratorService.findById(id);
		if (admin != null) {
			return new ResponseEntity<>(admin, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/admin")
	public ResponseEntity<?> save(@RequestBody AdministratorEntity admin) {
		
			administratorService.save(admin);
			return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<?> deleteyId(@PathVariable("id") Long id) {
		AdministratorEntity admin = administratorService.findById(id);
		if (admin != null) {
			administratorService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
