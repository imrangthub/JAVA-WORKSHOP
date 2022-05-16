package com.imranmadbar.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsApplMain5 {

	public static void main(String[] args) {

//		 Pattern rechargeAmountPrattern = Pattern.compile("(?<=\\s)(\\d*?)(?=tk)");
//		 Pattern rechargeAmountPrattern = Pattern.compile("(\\d*?)(?=tk)");
//	   	 Matcher matcher = namePattern.matcher("49tk-2gb-7d C-1Tk");
		
//		Pattern namePattern = Pattern.compile("([a-zA-Z0-9-_/+]+\\s*?)");
//		Matcher matcher = namePattern.matcher("49tk-2gb-7d C-1Tk");
		
//		 Pattern validityInDayPattern = Pattern.compile("(?<=-)(\\d*?)(?=d)");
//		 Matcher matcher = validityInDayPattern.matcher("49tk-2gb-7d C-1Tk");
		
		
//	     Pattern minPattern = Pattern.compile("(\\d*?)(?=min)");
//        Matcher matcher = minPattern.matcher("93TK 160min 150SMS BL-any 150MB 15din");
		
//	     Pattern ratePattern = Pattern.compile("(?<=-)(\\d*?p/min)(?=-)");   
//         Matcher matcher = ratePattern.matcher("1 *49tk-2gb-7d C-1Tk");

//		 Pattern smsPattern = Pattern.compile("(?<=-)(\\d*?)(?=sms)");
//         Matcher matcher = smsPattern.matcher("1 *49tk-2gb-7d C-1Tk");
		
//		  Pattern dataProductPattern = Pattern.compile("(?<=-)([a-zA-Z0-9_+]+\\s*?)");
//	      Matcher matcher = dataProductPattern.matcher("49tk-2gb-7d C-1Tk");
	//	Matcher matcher = dataProductPattern.matcher("93TK 160min 150SMS BL any -150MB 15din");
	         
//	       
//	      Pattern minPattern = Pattern.compile("(\\d*?)(?=min)");
//        Matcher matcher = minPattern.matcher("93TK 160min 150SMS BL-any 150MB 15din");
		
//        Pattern dataMbPattern = Pattern.compile("(\\d*?)(?=MB)");
//        Matcher matcher = dataMbPattern.matcher("93TK 160min 150SMS BL-any 150MB 15din");
         
          
	    Pattern otherInformationPattern = Pattern.compile("(\\d*?)(?=\\))");
        Matcher matcher = otherInformationPattern.matcher(" 93TK 160min 150SMS BL-any 150MB 15din");

	    
	    
	    if(matcher.find()) {
	      System.out.println("Match found");
	      System.out.println("Match: "+matcher);
	      System.out.println("MatchGoup: "+matcher.group(0));
	    } else {
	      System.out.println("Match not found");
	    }

	}

}
