package com.imranmadbar.xmPref;

public class StringOps {

	public static void main(String[] args) {
		
		
		String myStr = "Md Imran Hossain";
		
		
		System.out.println(myStr.toUpperCase());
		
		System.out.println(myStr.toLowerCase());
		
		System.out.println(String.format("%100s", myStr));
		
		
		System.out.println(String.format("%50s",myStr).replace(" ","-"));
		
		
		System.out.println( new StringBuilder(myStr).reverse().toString());
		
		
		String[] namArr = myStr.split(" ");
		
		for(String strVal : namArr) {
			System.out.println(strVal);
		}
		
		
		
		System.out.println(new StringBuilder("abc").reverse());
		

		


		  

	}

}
