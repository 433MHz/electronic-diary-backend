package pl.krystian.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "teachers")
@Getter
@Setter
public class Teachers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long teacherID;
	private String firstName;
	private String lastName;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
			name = "teachers_subjects",
			joinColumns = @JoinColumn(name = "teacher_id"),
			inverseJoinColumns = @JoinColumn(name = "subject_id")
			)
	private List<Subjects> subjects = new ArrayList<>();
	
	@OneToOne(mappedBy = "teacher")
	private Classes classes;
	
}
