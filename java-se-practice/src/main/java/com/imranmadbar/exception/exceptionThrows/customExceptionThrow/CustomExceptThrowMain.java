package com.imranmadbar.exception.exceptionThrows.customExceptionThrow;

public class CustomExceptThrowMain {
	
	
	static void ageValidation(int age) throws InvalidAgeException {
		if(age<18) {
			throw new InvalidAgeException("This is invalid age");
		}
	}
	
	
	
	public static void main(String[] agrs) {
		
		System.out.println("Application runing.....");
		
		
		try {
			ageValidation(11);
		} catch (InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("Application run finish");
	}
	
	
	

}
