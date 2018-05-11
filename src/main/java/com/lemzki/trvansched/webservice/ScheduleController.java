package com.lemzki.trvansched.webservice;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lemzki.trvansched.exception.FileValidationException;
import com.lemzki.trvansched.model.Schedule;
import com.lemzki.trvansched.service.ScheduleService;
import com.lemzki.trvansched.util.ScheduleValidator;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
	
	@Value("${secretKey}")
	 private String secretKey;

	@Autowired
	ScheduleService scheduleService;

	@GetMapping("")
	public List<Schedule> getAllSchedulesByDirection(@RequestParam("direction") String direction) {
		return scheduleService.findByDirection(direction);
	}

	@GetMapping("/")
	public List<Schedule> getAllSchedules() {
		return scheduleService.findAll();
	}

	@GetMapping("/{id}")
	public Schedule getAllSchedulesByDirection(@PathVariable int id) {
		return scheduleService.findById(id);
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("scheduleFile") MultipartFile file,
			RedirectAttributes redirectAttributes, @RequestParam("secretKey") String key){
		if (!this.secretKey.equals(key)) {
			return "Not Authorized";
		}
		
		
		try {
			List<Schedule> scheduleList = ScheduleValidator.validate(file.getInputStream());
			
			scheduleService.deleteAll();
			
			scheduleService.saveAll(scheduleList);
			
			/*for (Schedule schedule : scheduleList) {
				scheduleService.save(schedule);
			}*/
		} catch (FileValidationException e) {
			return "Invalid File " + e.getMessage();
		} catch (Exception e) {
			return "ERROR " + e.getMessage();
		}
		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * System.out.println("RECEEIVED" + file.getName() + "   " +
		 * file.getOriginalFilename()); System.out.println("RECEIVED KEY " + key);
		 */

		return "SUCCESS";
	}

	@PostMapping("/upload-local")
	public String uploadSchedulesLocally(@RequestParam("secretKey") String key) throws FileValidationException {

		if (!this.secretKey.equals(key)) {
			return "Not Authorized";
		}
		
		
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("vschedule.csv");
		List<Schedule> scheduleList = ScheduleValidator.validate(inputStream);
		
		scheduleService.deleteAll();
		
		scheduleService.saveAll(scheduleList);
		
		/*for (Schedule schedule : scheduleList) {
			scheduleService.save(schedule);
		}*/

		return "SUCCESS";
	}
	
	
	
	@GetMapping("/delete")
	public String uploadSchedulesLocally() throws FileValidationException {
		scheduleService.deleteAll();
		return "SUCCESS";
	}

}
