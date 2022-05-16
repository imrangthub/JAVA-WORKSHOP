package com.imranmadbar.arrays;

public class MultiDimensionalArraysMain {

	public static void main(String[] args) {
		
		int[][] myNumbers = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
		
		System.out.println("MultiData:"+myNumbers[0][3]);
		
		for (int i = 0; i < myNumbers.length; ++i) {
			
			for (int j = 0; j < myNumbers[i].length; ++j) {
				System.out.println(myNumbers[i][j]);
			}
			
		}
		
		
	}

}
