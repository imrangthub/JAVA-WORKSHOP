package com.imranmadbar.threadOps;
public class ThreadLeakExample {

    public static void main(String[] args) {
        int threadCount = 0; // Counter for naming threads

        while (true) {
        	
        	

            Thread thread = new Thread(() -> {                       // Create a new thread that runs indefinitely
                try {
                    // Simulating some work in the thread
                    while (true) {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            // Set a custom name for the thread
            thread.setName("MyCustomThread-" + threadCount++);
            thread.start(); // Start the thread
            
            // Output the number of active threads and the latest thread name
            System.out.println("Active Threads: " + Thread.activeCount());
            System.out.println("Created: " + thread.getName());

            // Pause for a moment to reduce spamming the console
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            
            
        }
        
        
        
        
        
    }
}

