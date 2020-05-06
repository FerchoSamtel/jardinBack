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
@Table(name = "achievement")
@Getter @Setter
public class AchievementEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "period_id")
	private Long periodoId;
	
	@Column(name = "materia_id")
	private Long matterId;
	
	@Column(name = "teacher_achievement_Id")
	private Long teacherId;
	
	private static final long serialVersionUID = 1L;
}
