package co.com.jardin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "administrator")
@Getter @Setter
public class AdministratorEntity implements Serializable{

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo_user_admin_id")
	private Long codigoId;
	
	@OneToMany
	@JoinColumn(name = "admin_group_Id", referencedColumnName = "id")
	private List<GroupEntity> group;
	
	@OneToMany
	@JoinColumn(name = "admin_grade_Id", referencedColumnName = "id")
	private List<GradeEntity> grade;
	
	@OneToMany
	@JoinColumn(name = "admin_classroom_Id", referencedColumnName = "id")
	private List<ClassroomEntity> classRoom;
	
	@OneToMany
	@JoinColumn(name = "admin_area_Id", referencedColumnName = "id")
	private List<Area> area;
	
	@OneToMany
	@JoinColumn(name = "admin_matter_Id", referencedColumnName = "id")
	private List<MatterEntity> matter;
	
	@OneToMany
	@JoinColumn(name = "admin_horary_Id", referencedColumnName = "id")
	private List<HoraryEntity> horary;
	
	@OneToMany
	@JoinColumn(name = "admin_period_Id", referencedColumnName = "id")
	private List<PeriodEntity> period;
	
	private static final long serialVersionUID = 1L;
}
