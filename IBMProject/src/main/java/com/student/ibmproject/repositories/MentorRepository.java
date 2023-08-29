package com.student.ibmproject.repositories;

import com.student.ibmproject.entities.Mentor;
import com.student.ibmproject.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface MentorRepository extends JpaRepository<Mentor, Integer> {

}
