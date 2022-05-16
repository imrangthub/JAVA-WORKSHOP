package com.imranmadbar.exception;

public class ExceptionHandeling {

	public static void main(String args[]) {

		System.out.println("ExceptionHandeling Run");

		try {

			int num[] = { 1, 2, 3, 4 };
			System.out.println(num[5]);

		} catch (Exception e) {
			System.out.println(e);

		}

		System.out.println("Execution Done");

	}

}
