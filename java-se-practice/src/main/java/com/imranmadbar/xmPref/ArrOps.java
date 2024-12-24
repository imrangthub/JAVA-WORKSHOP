package com.imranmadbar.xmPref;

import java.io.InputStream;
import java.util.*;


public class ArrOps {
	
	public static void main(String args[]){  
		
		
		
		int[] myArr= {1,2,33,4,4,4,5,6,6,6,6,78,8};
		
		Set uniqSet = new HashSet();
		
		for (int item:myArr) {
			uniqSet.add(item);
		}
		
		Object[] uniqArr = uniqSet.toArray();
		
		
		for(Object item: uniqArr) {
			System.out.println(item);
		}
		
	
		
		
		
		
		

		
		
		
		
		
	}

}
