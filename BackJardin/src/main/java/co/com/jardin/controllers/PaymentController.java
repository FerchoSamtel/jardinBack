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

import co.com.jardin.entity.PaymentEntity;
import co.com.jardin.servie.IPaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	private IPaymentService iPaymentService;

	@Autowired
	public PaymentController(IPaymentService iPaymentService) {
		this.iPaymentService = iPaymentService;
	}
	
	@GetMapping("/payment")
	public ResponseEntity<?> findAll() {
		List<PaymentEntity> paumentList = iPaymentService.findAll();
		return new ResponseEntity<>(paumentList, HttpStatus.OK);
	}

	@GetMapping("/payment/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		PaymentEntity payment = iPaymentService.findById(id);
		if (payment != null) {
			return new ResponseEntity<>(payment, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/payment")
	public ResponseEntity<?> save(@RequestBody PaymentEntity paymentEntity) {
		iPaymentService.save(paymentEntity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/payment/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody PaymentEntity paymentEntity) {
		PaymentEntity payment = iPaymentService.findById(id);
		if (payment != null) {
			payment.setQuantity(paymentEntity.getQuantity());
			payment.setDescription(paymentEntity.getDescription());
			payment.setSecretaryId(paymentEntity.getSecretaryId());
			payment.setStudentId(paymentEntity.getStudentId());
			iPaymentService.save(payment);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/payment/{id}")
	public ResponseEntity<?> delteById(@PathVariable("id") Long id){
		iPaymentService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
