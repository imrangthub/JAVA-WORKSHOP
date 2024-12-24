package com.imranmadbar.xmPref;

import java.util.Scanner;

public class InputReverseString {
	
	public static void main(String args[]){  
		
       
		Scanner mysc = new Scanner(System.in);
		
		System.out.println("Enter name:\n");
		String inputSt = mysc.nextLine();
		
		
		System.out.println(new StringBuilder(inputSt).reverse());
		
		
		System.out.println( String.format("%50s", inputSt));
		  
		  
		
	}

}
