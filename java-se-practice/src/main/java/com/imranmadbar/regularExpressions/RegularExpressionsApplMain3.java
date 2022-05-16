package com.imranmadbar.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsApplMain3 {

	  public static void main(String[] args) {
		  
		    Pattern pattern = Pattern.compile("imran", Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher("MD IMRAN HOSSAIN MD");
		    
		    
		    if(matcher.find()) {
		      System.out.println("Match found");
		      System.out.println("Match: "+matcher);
		      System.out.println("MatchGoup: "+matcher.group(0));
		    } else {
		      System.out.println("Match not found");
		    }
		    
		    
		  }

}
