package pl.krystian.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krystian.entities.Classes;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {

}
