package com.student.ibmproject.repositories;

import com.student.ibmproject.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
