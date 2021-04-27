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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import pl.krystian.entities.Teachers;
import pl.krystian.entities.repositories.TeachersRepository;

@RestController
@RequestMapping("/teachers")
@CrossOrigin
public class TeacherApi {

	TeachersRepository teacherRepo;
	
	
	@Autowired
	public TeacherApi(TeachersRepository teacherRepo) {
		this.teacherRepo = teacherRepo;
	}



	@GetMapping("/getAll")
	public @ResponseBody List<Teachers> getTeachers() {
		return teacherRepo.findAll();
	}
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public void addTeacher(@RequestBody Teachers teachers) {
		teacherRepo.save(teachers);
	}
	
	@DeleteMapping("/remove/{}")
	public void removeTeacherById(@PathVariable Long id) {
		teacherRepo.deleteById(id);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Teachers> getTeacherById(@PathVariable Long id) {
		return teacherRepo.findById(id);
	}
}
