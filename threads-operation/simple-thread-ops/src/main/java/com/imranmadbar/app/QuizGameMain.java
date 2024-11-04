package com.imranmadbar.app;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class QuizGame implements Runnable {
    private String[] questions = {
        "What is the capital of France?",
        "What is 5 + 7?",
        "Name the planet closest to the Sun."
    };
    private String[] answers = {"Paris", "12", "Mercury"};
    private boolean timeUp = false;
    private boolean isCorrect = false;

    // Setter to signal when time is up
    public void setTimeUp() {
        timeUp = true;
    }

    // Quiz game logic
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length && !timeUp; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            
            // Collect the answer if time is not up
            String userAnswer = scanner.nextLine();

            if (timeUp) {
                System.out.println("Time's up! You lost the game.");
                return;
            }

            if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!");
                isCorrect = true;
            } else {
                System.out.println("Incorrect! The correct answer was: " + answers[i]);
                isCorrect = false;
            }
        }

        if (!timeUp && isCorrect) {
            System.out.println("Congratulations! You answered all questions correctly.");
        } else if (!isCorrect) {
            System.out.println("Game over! Better luck next time.");
        }

        scanner.close();
    }
}

class Timer implements Runnable {
    private int timeLimit;
    private QuizGame game;

    public Timer(int timeLimit, QuizGame game) {
        this.timeLimit = timeLimit;
        this.game = game;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(timeLimit); // Set the time limit for the quiz
            game.setTimeUp(); // Set time up if the player has exceeded the time limit
            System.out.println("\nTime's up!");
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted.");
        }
    }
}

public class QuizGameMain {
    public static void main(String[] args) {
        int timeLimit = 30; // 10 seconds to answer all questions

        QuizGame quizGame = new QuizGame();
        Timer timer = new Timer(timeLimit, quizGame);

        // Thread for quiz questions
        Thread quizThread = new Thread(quizGame);

        // Thread for the timer
        Thread timerThread = new Thread(timer);

        // Start both threads
        quizThread.start();
        timerThread.start();

        // Wait for both threads to complete
        try {
            quizThread.join();
            timerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Game interrupted.");
        }

        System.out.println("Thanks for playing!");
    }
}
