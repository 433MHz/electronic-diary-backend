package pl.krystian.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krystian.entities.Teachers;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Long> {

}
