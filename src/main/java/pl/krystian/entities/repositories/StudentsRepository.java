package pl.krystian.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krystian.entities.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long> {

}
