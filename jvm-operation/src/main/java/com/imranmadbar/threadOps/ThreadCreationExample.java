package com.imranmadbar.threadOps;

public class ThreadCreationExample {

    public static void main(String[] args) {
        // Start a loop to create a new thread every second
        while (true) {
            // Create a new thread
            Thread thread = new Thread(() -> {
                System.out.println("Thread " + Thread.currentThread().getName() + " is started.");

                // Keep the thread alive for 5 seconds
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Thread " + Thread.currentThread().getName() + " is terminating.");
            });

            // Start the thread
            thread.start();

            // Pause for 1 second before creating the next thread
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
