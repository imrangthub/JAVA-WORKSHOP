package com.imranmadbar.exception.exceptionThrows;

public class ExceptionThrowsMain {

	static void validate(String strVal) throws NullPointerException {
		
		if (strVal==null) {
			throw new NullPointerException("Null Pointing");
		} else
			System.out.println("Value is: "+strVal.toString());
	}

	public static void main(String args[]) {
		
		try {
			validate(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Successfully Application run finished");
	}

}
