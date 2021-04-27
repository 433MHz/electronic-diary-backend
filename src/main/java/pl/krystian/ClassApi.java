package pl.krystian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.entities.Classes;
import pl.krystian.entities.repositories.ClassesRepository;


@RestController()
@RequestMapping("/classes")
@CrossOrigin
public class ClassApi {
	
	ClassesRepository classesRepo;
	
	@Autowired
	public ClassApi(ClassesRepository classesRepo) {
		this.classesRepo = classesRepo;
	}

	@GetMapping("/getAll")
	public List<Classes> getClasses() {
		return classesRepo.findAll();
	}
	
	@PostMapping("/add")
	public void addClass(@RequestBody Classes classes) {
		classesRepo.save(classes);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeClassById(@PathVariable Long id) {
		classesRepo.deleteById(id);
	}
	
	@GetMapping("/get/{id}")
	public Classes getClassesById(@PathVariable Long id) {
		return classesRepo.getOne(id);
	}
}
