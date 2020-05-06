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
@Table(name = "matter")
@Getter @Setter
public class MatterEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "hourly_intensity")
//	intensidadHoraria
	private String hourlyIntensity ;
	
	@Column(name = "area_Id")
	private Long areaId;
	
	@OneToMany
	@JoinColumn(name = "matter_note_id", referencedColumnName = "id")
	private List<NoteEntity> matterId;
	
	@OneToMany
	@JoinColumn(name = "materia_id", referencedColumnName = "id")
	private List<AchievementEntity> achievementId;
	
	@OneToMany
	@JoinColumn(name = "matter_horary_id", referencedColumnName = "id")
	private List<HoraryEntity> matterHId;
	
	@OneToMany
	@JoinColumn(name = "matter_id", referencedColumnName = "id")
	private List<TeacherEntity> teacherId;
	
	@Column(name = "admin_matter_Id")
	private Long administratorId;
	
	private static final long serialVersionUID = 1L;
}
