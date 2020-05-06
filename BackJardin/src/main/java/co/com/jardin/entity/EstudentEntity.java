package co.com.jardin.entity;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "student")
@Getter @Setter
public class EstudentEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private float name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "birt_date")
	private Date birthDate;

	@Column(name = "attending")
	private String attending;

	@Column(name = "direction")
	private String direction;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "observation")
	private String observation;
	
	@OneToMany
	@JoinColumn(name = "payment_student_id", referencedColumnName = "id")
	private List<PaymentEntity> paymentId;
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JsonBackReference // PARA NO ENTRAR EN UN BUCLE INFINITO
//	@JoinTable(name = "student_payment", 
//	joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
//	inverseJoinColumns = @JoinColumn(name = "pyment_id", referencedColumnName = "id"))
//	private Set<PaymentEntity> paymentStudent = new HashSet<>();

	@Column(name = "secretary_student_Id")
	private Long secretaryId;

	private static final long serialVersionUID = 1L;
}
