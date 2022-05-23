package me.nopalfi.springboot.repositories;

import me.nopalfi.springboot.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
