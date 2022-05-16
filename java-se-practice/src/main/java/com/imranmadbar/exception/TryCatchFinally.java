package com.imranmadbar.exception;

public class TryCatchFinally {
	

	public static void main(String args[]) {
		
		System.out.println("ExceptionHandeling Run");
		
		try {
			
//			int data = 100 / 0;
		      
		      
		      String myStr= null;
		      myStr.toString();
		      
		      
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Out of Bound Exception !");
		}catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("Execution Finally block");	
		}
		
		System.out.println("Execution Done");

	}
	
	

}
