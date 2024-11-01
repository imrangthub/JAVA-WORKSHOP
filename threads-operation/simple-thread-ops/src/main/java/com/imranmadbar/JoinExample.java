package com.imranmadbar;

class MyTask implements Runnable {
    private final String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " (" + taskName + ") is running.");
        try {
            Thread.sleep(2000);  // Simulate work by sleeping for 2 seconds
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted.");
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " (" + taskName + ") has finished.");
    }
}

public class JoinExample {
    public static void main(String[] args) {
        // Creating multiple threads
        Thread thread1 = new Thread(new MyTask("Task1"), "Thread-1");
        Thread thread2 = new Thread(new MyTask("Task2"), "Thread-2");
        Thread thread3 = new Thread(new MyTask("Task3"), "Thread-3");

        // Start each thread
        System.out.println("Starting threads...");
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Main thread waits for each thread to finish by using join
            System.out.println("Waiting for Thread-1 to finish...");
            thread1.join();  // Waits until thread1 completes
            System.out.println("Thread-1 has finished.");

            System.out.println("Waiting for Thread-2 to finish...");
            thread2.join();  // Waits until thread2 completes
            System.out.println("Thread-2 has finished.");

            System.out.println("Waiting for Thread-3 to finish...");
            thread3.join();  // Waits until thread3 completes
            System.out.println("Thread-3 has finished.");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for threads to finish.");
        }

        System.out.println("All threads have completed. Main thread has finished execution.");
    }
}
