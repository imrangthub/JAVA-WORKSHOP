package com.imranmadbar.myUtil;

public class ShutdownHookExample {

    public static void main(String[] args) {
        // Registering a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown hook triggered. Cleaning up resources...");
            // Perform cleanup tasks here
            System.out.println("Cleanup complete. JVM shutting down.");
        }));

        System.out.println("Application is running. Press Ctrl+C to exit or terminate the program.");

        // Simulate some work
        try {
            Thread.sleep(10000); // Keep the application running for 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Application interrupted.");
        }

        System.out.println("Application exiting...");
    }
}

