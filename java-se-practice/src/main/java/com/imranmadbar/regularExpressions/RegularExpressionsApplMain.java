package com.imranmadbar.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsApplMain {

	  public static void main(String[] args) {
		    Pattern pattern = Pattern.compile("imran", Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher("MDIMRANHOSSAIN");
		    
		    
		    if(matcher.find()) {
		      System.out.println("Match found");
		    } else {
		      System.out.println("Match not found");
		    }
		    
		    
		  }

}
