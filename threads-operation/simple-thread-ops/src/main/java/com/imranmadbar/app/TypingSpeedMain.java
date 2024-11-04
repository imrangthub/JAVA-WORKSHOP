package com.imranmadbar.app;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class TypingSpeedGame {
    private String wordToType;
    private long startTime;

    public TypingSpeedGame(String word) {
        this.wordToType = word;
    }

    public void startGame() {
        System.out.println("Type the word: \"" + wordToType + "\" as fast as you can!");

        // Start the timer
        startTime = System.nanoTime();
    }

    public void checkTyping() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals(wordToType)) {
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            long milliseconds = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
            System.out.println("Great job! You took " + milliseconds + " milliseconds to type the word.");
        } else {
            System.out.println("Oops! The word didn't match. Try again next time.");
        }
    }
}

public class TypingSpeedMain {
    public static void main(String[] args) {
        String word = "racecar";  // Word to type
        TypingSpeedGame game = new TypingSpeedGame(word);

        // Thread to display the word and start the timer
        Thread gameStartThread = new Thread(game::startGame);

        // Thread for checking the player’s typing input
        Thread typingCheckThread = new Thread(game::checkTyping);

        // Start both threads
        gameStartThread.start();
        typingCheckThread.start();

        // Wait for both threads to finish
        try {
            gameStartThread.join();
            typingCheckThread.join();
        } catch (InterruptedException e) {
            System.out.println("Game interrupted.");
        }

        System.out.println("Game Over!");
    }
}
