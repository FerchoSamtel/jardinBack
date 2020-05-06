package co.com.jardin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.jardin.entity.PaymentEntity;
import co.com.jardin.repository.IPaymentRepository;
import co.com.jardin.servie.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {

	private IPaymentRepository paymentRepository;
	
	@Autowired
	public PaymentServiceImpl(IPaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public List<PaymentEntity> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public PaymentEntity findById(Long id) {
		return paymentRepository.findById(id).orElse(null);
	}

	@Override
	public PaymentEntity save(PaymentEntity paymentEntity) {
		return paymentRepository.save(paymentEntity);
	}

	@Override
	public void deleteById(Long id) {
		paymentRepository.deleteById(id);
	}
}
