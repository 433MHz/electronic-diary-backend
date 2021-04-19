package pl.krystian.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "students")
@Getter
@Setter
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
