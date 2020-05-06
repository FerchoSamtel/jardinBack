package co.com.jardin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class UserEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lasname")
	private String lasName;
	
	@Column(name = "document_type")
	private String documentType;
	
	@Column(name = "document_number")
	private String documentNumber;
	
	@Column(name = "birth_date", unique = true)
	private String birthDae;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "telefono")
	private String telefono ;
	
	@Column(name = "celular")
	private String celular ;

	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "photo")
	private String photo;
	
	@OneToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private RoleEntity roleId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_user_admin_id", referencedColumnName = "id", unique = true)
	private List<AdministratorEntity> adminUserId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_user_id", referencedColumnName = "id", unique = true)
	private List<Secretaryentity> secretaryId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_user_teacher_id", referencedColumnName = "id", unique = true)
	private List<TeacherEntity> teacherId;

	private static final long serialVersionUID = 1L;
}
