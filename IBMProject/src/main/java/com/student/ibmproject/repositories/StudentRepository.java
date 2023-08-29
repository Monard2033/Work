package com.student.ibmproject.repositories;
import com.student.ibmproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, Integer> {
}


