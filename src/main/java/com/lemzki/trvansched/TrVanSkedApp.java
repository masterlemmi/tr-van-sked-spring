package com.lemzki.trvansched;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.lemzki.trvansched.demo.Car;
import com.lemzki.trvansched.demo.CarRepository;
import com.lemzki.trvansched.model.Schedule;
import com.lemzki.trvansched.repository.ScheduleRepository;

@SpringBootApplication
@PropertySource("classpath:confidential.properties")
@EnableJpaAuditing
public class TrVanSkedApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TrVanSkedApp.class, args);
	}

	private void lalalaIchangedSomething() {

	}

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(DemoApplication.class); }
	 * 
	 * @Bean ApplicationRunner init(CarRepository repository) { return args -> {
	 * Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
	 * "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> { Car
	 * car = new Car(); car.setName(name); repository.save(car); });
	 * repository.findAll().forEach(System.out::println); }; }
	 * 
	 * @Bean ApplicationRunner init2(ScheduleRepository scheduleRepository) { return
	 * args -> { ClassLoader classLoader = getClass().getClassLoader(); InputStream
	 * inputStream = classLoader.getResourceAsStream("vschedule.csv"); CSVParser
	 * parser = CSVParser.parse(inputStream, Charset.forName("UTF-8"),
	 * CSVFormat.RFC4180.withHeader()); for (CSVRecord csvRecord : parser) { String
	 * time = csvRecord.get("time"); String vanId = csvRecord.get("van_id"); String
	 * route = csvRecord.get("route"); String location = csvRecord.get("location");
	 * String direction = csvRecord.get("direction");
	 * 
	 * Schedule schedule = new Schedule(); schedule.setDirection(direction);
	 * schedule.setLocation(location); schedule.setTime(parseTime(time));
	 * schedule.setVanId(Integer.parseInt(vanId)); schedule.setRoute(route);
	 * scheduleRepository.save(schedule);
	 * 
	 * }
	 * 
	 * }; }
	 * 
	 * private SimpleDateFormat sdf = new SimpleDateFormat("K:mm a");
	 * 
	 * private Date parseTime(String scheduleTime) throws ParseException { return
	 * sdf.parse(scheduleTime); }
	 */
}