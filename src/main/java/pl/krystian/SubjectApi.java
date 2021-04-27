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

import pl.krystian.entities.Subjects;
import pl.krystian.entities.repositories.SubjectsRepository;

@RestController()
@RequestMapping("/subjects")
@CrossOrigin
public class SubjectApi {

	SubjectsRepository subjectsRepo;

	@Autowired
	public SubjectApi(SubjectsRepository subjectsRepo) {
		this.subjectsRepo = subjectsRepo;
	}
	
	
	@GetMapping("/getAll")
	public List<Subjects> getAllSubjects() {
		return subjectsRepo.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Subjects> getSubjectById(@PathVariable Long id) {
		return subjectsRepo.findById(id);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeSubjectById(@PathVariable Long id) {
		subjectsRepo.deleteById(id);
	}
	
	@PostMapping("/add")
	public void addSubject(@RequestBody Subjects subjects) {
		subjectsRepo.save(subjects);
	}
}
