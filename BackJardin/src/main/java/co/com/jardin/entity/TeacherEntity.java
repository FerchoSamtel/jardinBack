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
@Table(name = "teachers")
@Getter @Setter
public class TeacherEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo_user_teacher_id")
	private Long codigoId;
	
	@OneToMany
	@JoinColumn(name = "teacher_achievement_Id", referencedColumnName = "id")
	private List<AchievementEntity> achievement;
	
	@Column(name = "matter_id")
	private Long matterId;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "matter_id", referencedColumnName = "id", unique = true)
//	private MatterEntity matterId;
	
	@OneToMany
	@JoinColumn(name = "teacher_horary_id", referencedColumnName = "id")
	private List<HoraryEntity> teacherId;
	
	@OneToMany
	@JoinColumn(name = "teacher_note_Id", referencedColumnName = "id")
	private List<NoteEntity> note;
	
	private static final long serialVersionUID = 1L;
}
