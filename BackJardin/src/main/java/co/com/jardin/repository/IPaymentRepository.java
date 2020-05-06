package co.com.jardin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jardin.entity.PaymentEntity;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
