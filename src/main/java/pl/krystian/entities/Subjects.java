package pl.krystian.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "subjects")
@Getter
@Setter
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "subjectID")
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subjectID;
	private String subjectName;
	
	@ManyToMany(mappedBy = "subjects")
	private List<Teachers> teachers = new ArrayList<>(); 
}
