public class BadThreadExample {
    public static void main(String[] args) {
        System.out.println("Starting bad thread example...");

        // Continuously create new threads in an infinite loop
        while (true) {
            new Thread(new Worker()).start();
        }
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        try {
            // Simulate some work
            Thread.sleep(10000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Worker thread has finished.");
    }
}

