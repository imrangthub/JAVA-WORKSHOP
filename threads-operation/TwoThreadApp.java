public class TwoThreadApp {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Hello from TwoThreadApp1");
            try {
                // Sleep for 1 second (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted. Exiting...");
                break; // Exit the loop if interrupted
            }
           System.out.println("Hello from TwoThreadApp2");
        }
    }
}

