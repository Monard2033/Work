package com.student.ibmproject.repositories;

import com.student.ibmproject.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
