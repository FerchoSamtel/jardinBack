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
@Table(name = "note")
@Getter @Setter
public class NoteEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "note")
	private double note;
	
	@Column(name = "observation")
	private String observation;
	
	@Column(name = "matter_note_id")
	private Long matterId;
	
	@Column(name = "period_note_id")
	private Long periodoId;
	
	@Column(name = "teacher_note_Id")
	private Long teacherId;

	private static final long serialVersionUID = 1L;
}
