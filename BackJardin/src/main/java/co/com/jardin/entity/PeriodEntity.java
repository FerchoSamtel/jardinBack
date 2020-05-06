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
@Table(name = "period")
@Getter @Setter
public class PeriodEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany
	@JoinColumn(name = "period_note_id", referencedColumnName = "id")
	private List<NoteEntity> noteId;
	
	@OneToMany
	@JoinColumn(name = "period_id", referencedColumnName = "id")
	private List<AchievementEntity> achievementId;
	
	private String observation;
	
	@OneToMany
	@JoinColumn(name = "payment_period_id", referencedColumnName = "id")
	private List<PaymentEntity> paymentId;
	
	@Column(name = "admin_period_Id")
	private Long administratorId;
	
	private static final long serialVersionUID = 1L;
}
