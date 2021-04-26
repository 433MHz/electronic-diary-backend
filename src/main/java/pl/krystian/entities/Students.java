package pl.krystian.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerators;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "students")
@Getter
@Setter
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "studentID")
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentID;
	private String firstName;
	private String lastName;
	private int phoneNumber;
	
	@ManyToOne
	private Classes classID;

}
