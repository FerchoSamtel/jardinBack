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
@Table(name = "clasrooms")
@Getter @Setter
public class ClassroomEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "number", unique = true)
	private String number;
	
	@Column(name = "floor")
	private String floor;
	
	@Column(name = "admin_classroom_Id")
	private Long administratorId;
	
	@OneToMany
	@JoinColumn(name = "horary_classroom_id", referencedColumnName = "id")
	private List<HoraryEntity> horaryId;
	
	private static final long serialVersionUID = 1L;
}
