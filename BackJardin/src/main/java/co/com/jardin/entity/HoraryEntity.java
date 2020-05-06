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
@Table(name = "horary")
@Getter @Setter
public class HoraryEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "horary_classroom_id")
	private Long classroomId;
	
	@Column(name = "matter_horary_id")
	private Long matterId;

	@Column(name = "horary_grade_id")
	private Long gradeId;
	
	@Column(name = "admin_horary_Id")
	private Long adminId;
	
	@Column(name = "teacher_horary_id")
	private Long teacherId;
	
	private static final long serialVersionUID = 1L;
}
