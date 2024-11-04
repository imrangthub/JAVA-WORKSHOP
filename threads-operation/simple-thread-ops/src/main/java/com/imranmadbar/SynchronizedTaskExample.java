package com.imranmadbar;



class SimpleTask {
	
    public synchronized void performTask(int sleepTime) {
        System.out.println(Thread.currentThread().getName() + " is performing the task...");
        try {
            Thread.sleep(sleepTime); // Simulate some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + " finished the task.");
    }
    
}



public class SynchronizedTaskExample {
    public static void main(String[] args) {
    	
//        SimpleTask task1 = new SimpleTask();         With different task obj synchronized not working, synchronized work for same Object.
//        SimpleTask task2 = new SimpleTask();
        
        SimpleTask task3 = new SimpleTask();

        Thread thread1 = new Thread(() -> task3.performTask(1000), "Thread 1");
        Thread thread2 = new Thread(() -> task3.performTask(2000), "Thread 2");
        Thread thread3 = new Thread(() -> task3.performTask(10000), "Thread 3");
        
        thread3.start();
        
        thread1.start();
        thread2.start();
    }
}
