package com.imranmadbar.memoryOps.allocatedMemIdentify;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AllocateMemClassIdentifyMain {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        // Get the total memory in bytes
        long totalMemory1 = runtime.totalMemory();

        // Get the free memory in bytes
        long freeMemory1 = runtime.freeMemory();

        // Calculate the available memory in bytes
        long useByApp1 = totalMemory1 - freeMemory1;

        // Convert the memory values to megabytes
        long initTotal = totalMemory1 / (1024 * 1024);
        long initFree = freeMemory1 / (1024 * 1024);
        long initUseByApp = useByApp1 / (1024 * 1024);

        // Print the memory information in megabytes
        System.out.println("initTotal: " + initTotal + " MB, "+"initFree: " + initFree + " MB, "+"initUseByApp: " + initUseByApp + " MB");
        System.out.println();

        
        try {

            while (true) {

            	CustomerInfo csObj = new CustomerInfo();
            	csObj.makeCustomerMemConsumer(5);
                
                
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();
                long useByApp = totalMemory - freeMemory;
                
                long totalMemoryMB = totalMemory / (1024 * 1024);
                long freeMemoryMB = freeMemory / (1024 * 1024);
                long useByAppMB= useByApp / (1024 * 1024);	
                		
                System.out.println("GrowGCProgram is running..."+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                System.out.println("totalMemory: " + totalMemoryMB + " MB, "+"freeMemory: " + freeMemoryMB + " MB, "+"useByAppMB: " + useByAppMB + " MB");
                System.out.println();
                Thread.sleep(1000); // Sleep for 1 second to prevent high CPU usage
            }
        } catch (OutOfMemoryError e) {
            // Catch OutOfMemoryError if there is not enough memory to allocate
            System.err.println("Failed to allocate ##########  app  #######MB of memory.");
            e.printStackTrace();
        } catch (Exception e) {
            // Catch InterruptedException if the sleep is interrupted
            e.printStackTrace();
        }
    }
    
    
    
}