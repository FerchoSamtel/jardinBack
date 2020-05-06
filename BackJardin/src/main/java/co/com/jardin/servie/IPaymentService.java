package co.com.jardin.servie;

import java.util.List;

import co.com.jardin.entity.PaymentEntity;

public interface IPaymentService {

	public List<PaymentEntity> findAll();
	
	public PaymentEntity findById(Long id);
	
	public PaymentEntity save(PaymentEntity paymentEntity);
	
	public void deleteById(Long id);
}
