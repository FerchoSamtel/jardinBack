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
@Table(name = "grade")
@Getter @Setter
public class GradeEntity  implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", unique =  true)
	private String name;
	
	@Column(name = "group_id")
	private Long groupId;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "group_id", referencedColumnName = "id", unique = true)
//	private GroupEntity groupId;
	
	@Column(name = "admin_grade_Id")
	private Long administratorId;
	
	@OneToMany
	@JoinColumn(name = "grade_student_id", referencedColumnName = "id")
	private List<EstudentEntity> gradeId;
	
	@OneToMany
	@JoinColumn(name = "horary_grade_id", referencedColumnName = "id")
	private List<HoraryEntity> horaryId;
	
	private static final long serialVersionUID = 1L;
}
