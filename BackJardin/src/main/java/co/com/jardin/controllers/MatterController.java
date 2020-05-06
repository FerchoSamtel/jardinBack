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

import co.com.jardin.entity.MatterEntity;
import co.com.jardin.servie.IMatterService;

@RestController
@RequestMapping("/matter")
@CrossOrigin(origins = "http://localhost:4200")
public class MatterController {

	private IMatterService iMatterService;

	@Autowired
	public MatterController(IMatterService iMatterService) {
		this.iMatterService = iMatterService;
	}
	
	@GetMapping("/matter")
	public ResponseEntity<?> findAll(){
		List<MatterEntity> materList = iMatterService.findAll();
		return new ResponseEntity<>(materList, HttpStatus.OK);
	}
	
	@GetMapping("/matter/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		MatterEntity matter = iMatterService.findById(id);
		return new ResponseEntity<>(matter,HttpStatus.OK);
	}
	
	@PostMapping("/matter")
	public ResponseEntity<?> save(@RequestBody MatterEntity matterEntity){
		iMatterService.save(matterEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/matter/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody MatterEntity matterEntity){
		MatterEntity matterDb = iMatterService.findById(id);
		if(matterDb != null) {
			matterDb.setName(matterEntity.getName());
			matterDb.setHourlyIntensity(matterEntity.getHourlyIntensity());
			matterDb.setAreaId(matterEntity.getAreaId());
			iMatterService.save(matterDb);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@DeleteMapping("/matter/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		iMatterService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
