package com.imranmadbar.xmPref;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOps {
	
	public static void main(String args[]){  
		


		 List<String> list=new ArrayList<String>();  
		 list.add("Mango");  
		 list.add("Apple");  
		 list.add("Apple");  
		 list.add("Banana");  
		 list.add("Grapes");  

         
		 List<Integer> myList = Arrays.asList(1,2,3,3,3,4,4,6,0,0);
		 
		  Set uniqueList = new HashSet();
//		  List dumList = new ArrayList();
		  
		  Set dumList = new HashSet();
		  
		  for (Integer item : myList) {
			  if(!uniqueList.add(item)) {
				  dumList.add(item);
			  }
		  }
		 
	

	     System.out.println(uniqueList);
		 System.out.println(dumList);

	}
	
	

}
