package com.imranmadbar.memoryOps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResourceLeakExample {

    public static void main(String[] args) {
        createFileWithLeak();
    }

    private static void createFileWithLeak() {
        try {
            File file = new File("leakyFile.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            // Writing data to the file
            writer.write("This is a memory leak example.");

            // Not closing the writer, causing a resource leak
            // writer.close();

            System.out.println("File created. Press enter to finish and attempt resource cleanup.");
            System.in.read();

            // Attempting to clean up resources, but it won't work because the writer wasn't closed
            writer.close();
            System.out.println("Resource cleanup attempted. Check for resource leaks.");

            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}