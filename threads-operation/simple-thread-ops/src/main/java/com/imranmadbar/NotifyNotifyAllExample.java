package com.imranmadbar;


public class NotifyNotifyAllExample {
    public static void main(String[] args) {
    	
        SharedResource resource = new SharedResource();

        // Creating multiple waiting threads
        Thread waitingThread1 = new Thread(() -> resource.waitForSignal(), "Waiting-Thread-1");
        Thread waitingThread2 = new Thread(() -> resource.waitForSignal(), "Waiting-Thread-2");
        Thread waitingThread3 = new Thread(() -> resource.waitForSignal(), "Waiting-Thread-3");

        waitingThread1.start();
        waitingThread2.start();
        waitingThread3.start();

        // Giving the threads a moment to start and call wait
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Notifier thread to send a signal
        Thread notifierThread = new Thread(() -> {
          //  resource.sendNotify();  // You can switch to sendNotifyAll() here to see the difference
            resource.sendNotifyAll();  // You can switch to sendNotifyAll() here to see the difference
        }, "Notifier-Thread");

        notifierThread.start();
    }
}

class SharedResource {
    private final Object lock = new Object();

    public void waitForSignal() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is waiting for a signal.");
            try {
                lock.wait();  // Waiting for notification
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " received the signal and resumed.");
        }
    }

    public void sendNotify() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is sending a notify signal.");
            lock.notify();  // Sends signal to wake up ONE waiting thread
        }
    }

    public void sendNotifyAll() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is sending a notifyAll signal.");
            lock.notifyAll();  // Sends signal to wake up ALL waiting threads
        }
    }
}
