package com.imranmadbar.xmPref;

public class FibonacciNumbers {
	
	
	
	public static void main(String args[]){ 
	
    int num1 = 0, num2 = 1, num3=0;

    for (int i = 0; i <=100; i++) {
    	
        System.out.print(num1 + " ");
        
        num3 = num2 + num1;
        num1 = num2;
        num2 = num3;
    }
    
    
    
	}
    
    
    

}
