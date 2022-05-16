package com.imranmadbar.collectionFramework.map;

import java.util.*;  
public class MapMainCls {
	
	 public static void main(String args[]){  
		 
			System.out.println("MapMain Runing");
			
			
		 Map<Integer,String> map=new HashMap<Integer,String>();          
		       map.put(101,"Amit");       
		       map.put(103,"Rahul");    
		       map.put(104,"Vijay");  
		       map.put(102,"imran"); 
		       map.put(102,"Rahul"); 
		      //Returns a Set view of the mappings contained in this map    
		      map.entrySet()  
		      //Returns a sequential Stream with this collection as its source  
		      .stream()  
		      //Sorted according to the provided Comparator  
		      .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))  
		      //Performs an action for each element of this stream  
		      .forEach(System.out::println);  
		  } 
	 
	 

}
