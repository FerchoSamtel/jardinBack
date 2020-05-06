package co.com.jardin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "secretary")
@Getter @Setter
public class Secretaryentity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo_user_id")
	private Long codigoId;
	
	@OneToMany
	@JoinColumn(name = "secretary_student_Id", referencedColumnName = "id")
	private List<EstudentEntity> studente;
	
	@OneToMany
	@JoinColumn(name = "secretary_payment_Id", referencedColumnName = "id")
	private List<PaymentEntity> payment;
	
	private static final long serialVersionUID = 1L;
}
