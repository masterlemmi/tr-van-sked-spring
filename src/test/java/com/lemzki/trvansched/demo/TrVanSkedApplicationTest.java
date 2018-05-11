package com.lemzki.trvansched.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrVanSkedApplicationTest {

	@Test
	public void contextLoads() {
	}
	
	//@Test
	public void testdate() throws ParseException {
		String sdate = "1:00 AM";
		System.out.println("1.) " + sdf.parse(sdate));
		
		
		String sdate2 = "1:00 PM";
		
		System.out.println("2.) " + sdf.parse(sdate2));
	}
	
	
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");

	

}
