package com.student.ibmproject.repositories;

import com.student.ibmproject.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface SessionRepository extends JpaRepository<Session,Integer> {
}
