package com.imranmadbar.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsApplMain2 {

	  public static void main(String[] args) {


		  System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)  
		  System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)  
		  System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once) 
		 
		    
		    
		  }

}
