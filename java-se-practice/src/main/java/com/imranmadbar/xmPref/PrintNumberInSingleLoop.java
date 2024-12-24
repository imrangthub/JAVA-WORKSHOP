package com.imranmadbar.xmPref;

public class PrintNumberInSingleLoop {

	
	
	public static void main(String[] args) {
		
			
		int rsVal = 0;
		int increVal=1;
		
		
		for(int i=1; i<=19; i++) {
			
			if(rsVal==10) {
				increVal=-1;
			}
			   rsVal+=increVal;
			
			System.out.println(rsVal);
		}
 

		
	}

}
