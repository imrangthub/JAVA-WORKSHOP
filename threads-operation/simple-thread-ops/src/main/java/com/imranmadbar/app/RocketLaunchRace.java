package com.imranmadbar.app;

class Rocket implements Runnable {
    private String name;
    private int countdownTime;

    public Rocket(String name, int countdownTime) {
        this.name = name;
        this.countdownTime = countdownTime;
    }

    @Override
    public void run() {
        System.out.println(name + " countdown started!");
        try {
            while (countdownTime > 0) {
                System.out.println(name + " T-minus " + countdownTime + " seconds");
                countdownTime--;

                // Pause for 1 second to simulate real-time countdown
                Thread.sleep(1000);
            }
            System.out.println(name + " has launched!");
        } catch (InterruptedException e) {
            System.out.println(name + " countdown interrupted.");
        }
    }
}

public class RocketLaunchRace {
    public static void main(String[] args) {
        // Create two rockets with different countdown times
        Rocket rocket1 = new Rocket("Rocket 1", 5);  // 5-second countdown
        Rocket rocket2 = new Rocket("Rocket 2", 3);  // 3-second countdown

        // Start each rocket's countdown in a separate thread
        Thread rocketThread1 = new Thread(rocket1);
        Thread rocketThread2 = new Thread(rocket2);

        System.out.println("Rocket launch countdown race has started!");
        rocketThread1.start();
        rocketThread2.start();

        // Wait for both rockets to launch
        try {
            rocketThread1.join();
            rocketThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Launch interrupted.");
        }

        System.out.println("The race has ended!");
    }
}
