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

import co.com.jardin.entity.UserEntity;
import co.com.jardin.servie.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	private IUserService iUserService;

	@Autowired
	public UserController(IUserService iUserService) {
		this.iUserService = iUserService;
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> findAll(){
		List<UserEntity> userDb = iUserService.findAll();
		if(userDb != null) {
			return new ResponseEntity<>(userDb,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(userDb,HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserEntity> findById(@PathVariable( "id")Long id){
		UserEntity userDb = iUserService.findById(id);
		if(userDb != null) {
			iUserService.findById(id);
			return new ResponseEntity<UserEntity>(userDb,HttpStatus.OK);
		}else {
			return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> save(@RequestBody UserEntity user){
		iUserService.save(user);
		return new ResponseEntity<UserEntity>(HttpStatus.CREATED);
//		UserEntity userDb = iUserService.findById(user.getId());
//		if(userDb != null) {
//			iUserService.save(userDb);
//			return new ResponseEntity<UserEntity>(HttpStatus.CREATED);
//		}else {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody UserEntity user){
		UserEntity userDb = iUserService.findById(id);
		if(userDb != null) {
			userDb.setName(user.getName());
			userDb.setLasName(user.getLasName());
			userDb.setDocumentType(user.getDocumentType());
			userDb.setDocumentNumber(user.getDocumentNumber());
			userDb.setBirthDae(user.getBirthDae());
			userDb.setEmail(user.getEmail());
			userDb.setPassword(user.getPassword());
			userDb.setStatus(user.getStatus());
			userDb.setPhoto(user.getPhoto());
			userDb.setTelefono(user.getTelefono());
			userDb.setCelular(user.getCelular());
			userDb.setRoleId(user.getRoleId());
			iUserService.save(userDb);
			return new ResponseEntity<>(iUserService, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id")Long id){
		UserEntity userDb = iUserService.findById(id);
		if(userDb != null) {
			iUserService.deleteById(id);
			return new ResponseEntity<UserEntity>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

}
