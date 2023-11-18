package com.imranmadbar.memoryOps;

public class MemoryConsumer {

    public static void main(String[] args) {
        // Specify the amount of memory to allocate in megabytes
        int memoryToAllocateMB = 10;

        // Calculate the number of bytes corresponding to the specified megabytes
        long bytesToAllocate = memoryToAllocateMB * 1024L * 1024L;

        try {
            // Allocate an array to hold the specified amount of memory
            byte[] memoryArray = new byte[(int) bytesToAllocate];

            // Print a message indicating successful memory allocation
            System.out.println("Successfully allocated " + memoryToAllocateMB + "MB of memory.");

            // Keep the program running to hold the allocated memory
            while (true) {
                Thread.sleep(1000); // Sleep for 1 second to prevent high CPU usage
            }
        } catch (OutOfMemoryError e) {
            // Catch OutOfMemoryError if there is not enough memory to allocate
            System.err.println("Failed to allocate " + memoryToAllocateMB + "MB of memory.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            // Catch InterruptedException if the sleep is interrupted
            e.printStackTrace();
        }
    }
}