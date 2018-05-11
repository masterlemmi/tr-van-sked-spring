package com.lemzki.trvansched.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemzki.trvansched.model.Schedule;
import com.lemzki.trvansched.repository.ScheduleRepository;
import com.lemzki.trvansched.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;

	@Override
	public List<Schedule> findAll() {
		return scheduleRepository.findAll();
	}

	@Override
	public List<Schedule> findByDirection(String direction) {
		/*return findAll().stream().filter(s -> s.getDirection().equalsIgnoreCase(direction))
				.collect(Collectors.toList());*/
		
		return scheduleRepository.findByDirection(direction);
	}

	@Override
	public void save(Schedule schedule) {
		scheduleRepository.save(schedule);
	}
	
	@Override
	public void saveAll(List<Schedule> schedules) {
		scheduleRepository.saveAll(schedules);
		
	}

	@Override
	public Schedule findById(int id) {
		return scheduleRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteAll() {
		 scheduleRepository.deleteAllInBatch();
	}

	

}
