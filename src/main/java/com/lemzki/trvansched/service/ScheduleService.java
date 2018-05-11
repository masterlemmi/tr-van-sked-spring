package com.lemzki.trvansched.service;

import java.util.List;

import com.lemzki.trvansched.model.Schedule;

public interface ScheduleService {

	List<Schedule> findAll();
	
	List<Schedule> findByDirection(String direction);

	void save(Schedule schedule);
	
	void saveAll(List<Schedule> schedules);
	
	
	Schedule findById(int id);
	
	void deleteAll();


	
}
