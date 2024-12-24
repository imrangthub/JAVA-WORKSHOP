package com.imranmadbar.xmPref;

import java.util.Scanner;

public class SumTwoInput {

	public static void main(String[] args) {
		
		int val1, val2, rs;

		Scanner mysc = new Scanner(System.in);
		
		System.out.println("Enter Number one: ");
		val1= mysc.nextInt();
		
		
		System.out.println("Enter Number Two:");
		val2 = mysc.nextInt();
		
		rs=val1+val2;
		
		System.out.println("Result is:"+rs);
		
		
		

	}

}
