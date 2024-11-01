package com.imranmadbar;

class MyTask2 implements Runnable {
    private final String taskName;

    public MyTask2(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " (" + taskName + ") is running.");
        try {
            Thread.sleep(2000); // Simulate some work for 2 seconds
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted.");
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " (" + taskName + ") has finished.");
    }
}

public class MultiThreadExample {
    public static void main(String[] args) {
        // Step 1: Create multiple threads
        Thread thread1 = new Thread(new MyTask2("Task1"), "Thread-1");
        Thread thread2 = new Thread(new MyTask2("Task2"), "Thread-2");
        Thread thread3 = new Thread(new MyTask2("Task3"), "Thread-3");

        // Step 2: Start each thread
        System.out.println("Starting threads...");
        thread1.start();
        thread2.start();
        thread3.start();

        // Optional: Wait for each thread to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for other threads to finish.");
        }

        System.out.println("Main thread has finished execution.");
    }
}
