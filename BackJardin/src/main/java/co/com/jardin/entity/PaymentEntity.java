package co.com.jardin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter @Setter
public class PaymentEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "quantity")
	private float quantity;

	@Column(name = "description")
	private String description;

	@Column(name = "payment_student_id")
	private Long studentId;
	
//	@ManyToMany
//	@JoinTable(name = "student_payment", 
//			joinColumns = @JoinColumn(name = "pyment_id", referencedColumnName = "id"), 
//			inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
//	private Set<EstudentEntity> paymanStudent = new HashSet<>();
	
	@Column(name = "secretary_payment_Id")
	private Long secretaryId;

	private static final long serialVersionUID = 1L;
}
