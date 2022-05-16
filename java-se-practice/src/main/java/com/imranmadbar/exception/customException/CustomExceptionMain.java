package com.imranmadbar.exception.customException;

public class CustomExceptionMain {

	public static void main(String args[]) {

		System.out.println("==========  CustomExceptionMain Run  ============sss");

		try {

//			throw new CustomExceptionInvlaidAge("Warring, Invlaid age !");
			
			int age = 17;
			
			if(age <18) {
				throw new CustomExceptionInvlaidAge("Warring, Invlaid age !");
			}
			System.out.println("Welcome to Vot");

		} 
		
		catch (CustomExceptionInvlaidAge e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("Execution Done");
	}
	

	
}
