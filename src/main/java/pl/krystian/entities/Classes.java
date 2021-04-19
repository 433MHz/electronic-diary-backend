package pl.krystian.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "classes")
@Getter
@Setter
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long classID;
	private String className;
	
	@OneToOne
	private Teachers teacher;
	
	@OneToMany(mappedBy = "classID")
	private List<Students> students = new ArrayList<>();
}
