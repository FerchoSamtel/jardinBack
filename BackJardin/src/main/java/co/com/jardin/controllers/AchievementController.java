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

import co.com.jardin.entity.AchievementEntity;
import co.com.jardin.servie.IArchievementService;

@RestController
@RequestMapping("/achievement")
@CrossOrigin(origins = "http://localhost:4200")
public class AchievementController {

	private IArchievementService achievementService;

	@Autowired
	public AchievementController(IArchievementService achievementService) {
		this.achievementService = achievementService;
	}
	
	@GetMapping("/achievement")
	public ResponseEntity<?> findAll(){
		List<AchievementEntity> list = achievementService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/achievement/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		AchievementEntity list = achievementService.findById(id);
		if(list != null) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@PostMapping("/achievement")
	public ResponseEntity<?> save(@RequestBody AchievementEntity achievementEntity){
		achievementService.save(achievementEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/achievement/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody AchievementEntity achievementEntity){
		AchievementEntity list = achievementService.findById(id);
		if(list != null) {
			list.setDescription(achievementEntity.getDescription());
			list.setName(achievementEntity.getName());
			list.setPeriodoId(achievementEntity.getPeriodoId());
			list.setMatterId(achievementEntity.getMatterId());
			achievementService.save(list);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@DeleteMapping("/achievement/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		achievementService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
