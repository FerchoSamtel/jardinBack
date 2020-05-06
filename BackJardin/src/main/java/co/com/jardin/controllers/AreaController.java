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

import co.com.jardin.entity.Area;
import co.com.jardin.servie.IAreaService;

@RestController
@RequestMapping("/area")
@CrossOrigin(origins = "http://localhost:4200")
public class AreaController {
	
	private IAreaService areaService;

	@Autowired
	public AreaController(IAreaService areaService) {
		this.areaService = areaService;
	}
	
	@GetMapping("/area")
	public ResponseEntity<?> findAll(){
		List<Area> areaList = areaService.findAll();
		return new ResponseEntity<>(areaList, HttpStatus.OK);
	}

	@GetMapping("/area/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Area areaId = areaService.findById(id);
		return new ResponseEntity<>(areaId, HttpStatus.OK);
	}
	
	@PostMapping("/area")
	public ResponseEntity<?> save(@RequestBody Area area){
		areaService.save(area);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/area/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Area area){
		Area areaBd = areaService.findById(id);
		if(areaBd != null) {
			areaBd.setName(area.getName());
			areaService.save(areaBd);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}		
	}
	
	@DeleteMapping("/area/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		areaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
