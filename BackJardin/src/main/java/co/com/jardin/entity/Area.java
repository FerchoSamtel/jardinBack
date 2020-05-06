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
@Table(name = "area")
@Getter @Setter
public class Area implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "admin_area_Id")
	private Long administratorId;
	
	@OneToMany
	@JoinColumn(name = "area_id", referencedColumnName = "id")
	private List<MatterEntity> areaId;
	
	private static final long serialVersionUID = 1L;
}
