package com.imranmadbar.memoryOps;

import java.util.ArrayList;
import java.util.List;

public class SimpleMemoryLeak {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList();

        while (true) {
            // Generating and adding strings to the list
            String newString = generateString();
            stringList.add(newString);

            // Uncommenting the line below would fix the memory leak
            // stringList.clear();
        }
    }

    private static String generateString() {
        // Generating a random string (for the sake of example)
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }
}