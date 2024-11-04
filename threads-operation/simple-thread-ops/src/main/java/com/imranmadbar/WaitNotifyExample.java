package com.imranmadbar;

class WaitNotifyExampleTask {
	
    public void performTask(Object lock) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            try {
                lock.wait();  // The thread releases the lock and waits
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + " is resumed after notification.");
        }
    }

    
    public void notifyTask(Object lock) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is notifying...");
            lock.notify();  // Notifies one waiting thread
        }
    }
    
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        Object lock = new Object();                                       //Its a monitor object, The lock object acts as a common monitor between the threads for coordination.
        WaitNotifyExampleTask task = new WaitNotifyExampleTask();

        Thread waitingThread = new Thread(() -> task.performTask(lock), "WaitingThread");
        Thread notifyingThread = new Thread(() -> task.notifyTask(lock), "NotifyingThread");
        waitingThread.start();
        
        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        
        notifyingThread.start();
        
    }
}
