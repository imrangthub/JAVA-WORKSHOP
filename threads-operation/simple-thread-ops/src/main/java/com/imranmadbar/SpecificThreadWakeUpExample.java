package com.imranmadbar;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SpecificThreadWakeUpExample {
    public static void main(String[] args) {
        ThreadController controller = new ThreadController();

        Thread thread1 = new Thread(() -> controller.waitForSignal("A"), "Thread-A");
        Thread thread2 = new Thread(() -> controller.waitForSignal("B"), "Thread-B");
        Thread thread3 = new Thread(() -> controller.waitForSignal("C"), "Thread-C");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(1000);  // Give threads time to start and wait
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Sending signal to wake up a specific thread
        controller.signalSpecificThread("B");  // Only wakes up Thread-B
    }
}

class ThreadController {
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    public void waitForSignal(String threadType) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " waiting for signal.");
            switch (threadType) {
                case "A":
                    conditionA.await();  // Wait on conditionA
                    break;
                case "B":
                    conditionB.await();  // Wait on conditionB
                    break;
                case "C":
                    conditionC.await();  // Wait on conditionC
                    break;
                default:
                    break;
            }
            System.out.println(Thread.currentThread().getName() + " received the signal and resumed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public void signalSpecificThread(String threadType) {
        lock.lock();
        try {
            System.out.println("Signaling thread type: " + threadType);
            switch (threadType) {
                case "A":
                    conditionA.signal();  // Wakes up one thread waiting on conditionA
                    break;
                case "B":
                    conditionB.signal();  // Wakes up one thread waiting on conditionB
                    break;
                case "C":
                    conditionC.signal();  // Wakes up one thread waiting on conditionC
                    break;
                default:
                    break;
            }
        } finally {
            lock.unlock();
        }
    }
}
