package com.imranmadbar;

class MyThread extends Thread {
	
    @Override
    public void run() {
        System.out.println("Thread is running...");
        try {
            Thread.sleep(1000); // Thread enters Timed Waiting state
        } catch (InterruptedException e) {
            System.out.println("Thread got Exception");
        }
        System.out.println("Thread finished execution.");
    }
    
    
}




public class SubClassThread {

	public static void main(String[] args) {
		

	       MyThread thread = new MyThread(); // Thread is in New state
	        thread.start();                   // Thread enters Runnable state
	        try {
	            thread.join();                // Main thread waits for this thread to finish
	        } catch (InterruptedException e) {
	            System.out.println("Main thread Exception");
	        }
	        System.out.println("Main thread finished.");
	        
	        
	    }
	

}
