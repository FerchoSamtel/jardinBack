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

import co.com.jardin.entity.Secretaryentity;
import co.com.jardin.servie.ISecretaryService;

@RestController
@RequestMapping("/secretary")
@CrossOrigin(origins = "http://localhost:4200")
public class SecretaryController {

	private ISecretaryService iSecretaryService;

	@Autowired
	public SecretaryController(ISecretaryService iSecretaryService) {
		this.iSecretaryService = iSecretaryService;
	}
	
	@GetMapping("/secretary")
	public ResponseEntity<?> findAll(){
		List<Secretaryentity> secretaryList = iSecretaryService.findAll();
		return new ResponseEntity<>(secretaryList, HttpStatus.OK);
	}
	
	@GetMapping("/secretary/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Secretaryentity secretary = iSecretaryService.findById(id);
		if(secretary != null) {
			return new ResponseEntity<>(secretary, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(secretary, HttpStatus.NO_CONTENT);
		}		
	}
	
	@PostMapping("/secretary")
	public ResponseEntity<?> save(@RequestBody Secretaryentity secretaryentity){
		iSecretaryService.save(secretaryentity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/secretary/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Secretaryentity secretaryentity){
		Secretaryentity secretary = iSecretaryService.findById(id);
		if(secretary != null) {
			secretary.setCodigoId(secretaryentity.getCodigoId());
			iSecretaryService.save(secretary);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}		
	}
	
	@DeleteMapping("/secretary/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		iSecretaryService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
