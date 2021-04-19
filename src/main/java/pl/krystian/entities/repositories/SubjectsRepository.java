package pl.krystian.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krystian.entities.Subjects;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long> {

}
