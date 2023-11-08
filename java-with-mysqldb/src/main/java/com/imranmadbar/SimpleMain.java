package com.imranmadbar;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class SimpleMain {

	public static void main(String[] args) {
		// Create a LocalDateTime for Dhaka, Bangladesh
		//LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Dhaka"));
		   LocalDateTime localDateTime = LocalDateTime.now();
		   
		   
		System.out.println("LocalDateTime: " + localDateTime);
		

		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		
		
		System.out.println("ZonedDateTime: " + zonedDateTime);
		
		
	}

}
