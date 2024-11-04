package com.imranmadbar.app;


class Car implements Runnable {
    private String name;
    private static final int FINISH_LINE = 100; // Distance to the finish line

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int distanceCovered = 0;
        while (distanceCovered < FINISH_LINE) {
            try {
                // Move forward a random distance between 5 and 10
                int step = (int) (Math.random() * 6) + 5;
                distanceCovered += step;
                System.out.println(name + " has covered " + distanceCovered + " meters.");

                // Simulate a random delay between steps (speed variation)
                Thread.sleep((int) (Math.random() * 300) + 200);
            } catch (InterruptedException e) {
                System.out.println(name + " got interrupted.");
            }
        }
        System.out.println(name + " has crossed the finish line!");
    }
}

public class CarRaceThreadApp {
    public static void main(String[] args) {
        // Create two cars
        Car car1 = new Car("Car 1");
        Car car2 = new Car("Car 2");

        // Start the race by launching each car in a separate thread
        Thread raceThread1 = new Thread(car1);
        Thread raceThread2 = new Thread(car2);

        System.out.println("The race has started!");
        raceThread1.start();
        raceThread2.start();

        // Wait for both cars to finish the race
        try {
            raceThread1.join();
            raceThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Race interrupted.");
        }

        System.out.println("The race has ended!");
    }
}
