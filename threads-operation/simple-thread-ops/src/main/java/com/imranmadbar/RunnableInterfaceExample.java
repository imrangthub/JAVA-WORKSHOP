package com.imranmadbar;



class Task implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started.");
        try {
            Thread.sleep(30000); // 30 seconds
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
        System.out.println(threadName + " finished.");
    }
}


public class RunnableInterfaceExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new Task(), "Thread-" + i);
            thread.start();
        }
        System.out.println("MainMethod executation done !.");
    }
}
