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
@Table(name = "groups")
@Getter @Setter
public class GroupEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany
	@JoinColumn(name = "group_id", referencedColumnName = "id")
	private List<GradeEntity> groupId;
	
	@Column(name = "admin_group_Id")
	private Long administratorId;
	
	private static final long serialVersionUID = 1L;
}