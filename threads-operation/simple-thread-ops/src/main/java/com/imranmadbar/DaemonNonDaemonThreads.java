package com.imranmadbar;


public class DaemonNonDaemonThreads {
    public static void main(String[] args) {
        Thread nonDaemonThread = new Thread(new MyTask1(), "Non-Daemon-Thread");
        nonDaemonThread.setDaemon(false); // This is a non-daemon thread
        nonDaemonThread.start();

        Thread daemonThread = new Thread(new DemonTask(), "Daemon-Thread");
        daemonThread.setDaemon(true); // This is a daemon thread
        daemonThread.start();

        System.out.println("Main method is finished.");
    }
}

class MyTask1 implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started.");
        try {
            Thread.sleep(10000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
        System.out.println(threadName + " finished.");
    }
}

class DemonTask implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " started.");
        try {
            Thread.sleep(15000); // Sleep for 15 seconds
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
        System.out.println(threadName + " finished.");
    }
}