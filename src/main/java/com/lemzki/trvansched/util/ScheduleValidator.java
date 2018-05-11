package com.lemzki.trvansched.util;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.lemzki.trvansched.exception.FileValidationException;
import com.lemzki.trvansched.model.Schedule;

public class ScheduleValidator {

	private ScheduleValidator() {

	}

	public static List<Schedule> validate(InputStream inputStream) throws FileValidationException  {

		List<Schedule> list = new ArrayList<>();

		try {
			CSVParser parser = CSVParser.parse(inputStream, Charset.forName("UTF-8"), CSVFormat.RFC4180.withHeader());
			for (CSVRecord csvRecord : parser) {
				String time = csvRecord.get("time").trim();
				String vanId = csvRecord.get("van_id").trim();
				String route = csvRecord.get("route").trim();
				String location = csvRecord.get("location").trim();
				String direction = csvRecord.get("direction").trim();

				Schedule schedule = new Schedule();
				schedule.setDirection(direction);
				schedule.setLocation(location);
				schedule.setTime(parseTime(time));
				schedule.setVanId(Integer.parseInt(vanId));
				schedule.setRoute(route);
				list.add(schedule);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new FileValidationException(e.getMessage());
		}

		return list;

	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");

	private static Date parseTime(String scheduleTime) throws ParseException {
		return sdf.parse(scheduleTime);
	}

}
