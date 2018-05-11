package com.lemzki.trvansched.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lemzki.trvansched.model.Schedule;

@RepositoryRestResource
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	List<Schedule> findByDirection(String direction);
	
}