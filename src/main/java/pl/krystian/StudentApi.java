package pl.krystian;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.entities.Students;
import pl.krystian.entities.repositories.StudentsRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentApi {

	StudentsRepository studentRepo;

	@Autowired
	public StudentApi(StudentsRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	
	@GetMapping("/getAll")
	public List<Students> getAllStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Students> getStudentById(@PathVariable Long id) {
		return studentRepo.findById(id);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeStudentById(@PathVariable Long id) {
		studentRepo.deleteById(id);
	}
	
	@PostMapping("/add")
	public void addStudent(@RequestBody Students student) {
		studentRepo.save(student);
	}
	
}
