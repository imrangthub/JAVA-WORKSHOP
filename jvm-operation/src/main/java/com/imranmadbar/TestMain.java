package com.imranmadbar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestMain {

	public static void main(String[] args) {
		
        
        while (true) {

        
            System.out.println("Program is running..."+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            try {
                // Sleep for 1 second (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

	

}
