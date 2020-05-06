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

import co.com.jardin.entity.GroupEntity;
import co.com.jardin.servie.IGroupService;

@RestController
@RequestMapping("/group")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

	private IGroupService groupService;

	@Autowired
	public GroupController(IGroupService groupService) {
		this.groupService = groupService;
	}
	
	@GetMapping("/group")
	public ResponseEntity<?> findAll(){
		List<GroupEntity> group = groupService.findAll();
		return new ResponseEntity<>(group, HttpStatus.OK);
	}
	
	@GetMapping("/group/{id}")
	public ResponseEntity<?> finByIdl(@PathVariable("id") Long id){
		GroupEntity group = groupService.findById(id);
		return new ResponseEntity<>(group, HttpStatus.OK);
	}
	
	@PostMapping("/group")
	public ResponseEntity<?> save(@RequestBody GroupEntity groupEntity){
		groupService.save(groupEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/group/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody GroupEntity groupEntity){
		GroupEntity groupDb = groupService.findById(id);
		if(groupDb != null) {
			groupDb.setName(groupEntity.getName());
			groupService.save(groupEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@DeleteMapping("/group/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		groupService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
