public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Starting thread example...");

        // Create multiple threads
        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(i)).start();
        }
    }
}

class Worker implements Runnable {
    private final int id;

    public Worker(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            // Simulate some work
            for (int j = 0; j < 5; j++) {
                System.out.println("Thread " + id + " is working: " + j);
                Thread.sleep(5000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Thread " + id + " has finished working.");
    }
}

