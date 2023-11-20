package com.imranmadbar.memoryOps;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {

    // Static collection to hold references to objects
    private static List<Object> memoryLeakList = new ArrayList();

    public static void main(String[] args) {
        startLeak();
    }

    private static void startLeak() {
        for (int i = 0; i < 1000000; i++) {
            Object obj = new Object();
            memoryLeakList.add(obj);
        }

        System.out.println("Memory leak started. Press enter to finish and attempt garbage collection.");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // The objects are still referenced, preventing them from being garbage collected
        // Uncommenting the line below would release the references and allow the objects to be collected
        // memoryLeakList = null;

        System.gc(); // Request garbage collection

        System.out.println("Garbage collection requested. Check memory usage.");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}