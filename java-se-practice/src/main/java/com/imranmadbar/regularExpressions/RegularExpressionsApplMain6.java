package com.imranmadbar.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsApplMain6 {
	
    static void lookForKeyword(String message, String keyword) {
        System.out.println("Looking for keyword \"" + keyword + "\" in string \"" + message + "\"");
        String pattern = "^.*?-?([^-]*" + keyword +"[^-]*)-?.*$";
        Matcher matcher = Pattern.compile(pattern).matcher(message);
        if (matcher.matches()) {
            System.out.println("Found : \"" + matcher.group(1) + "\"");
        }
    }
    
    
    
    private static String getFirstKeywordMatch(String s, String keyword) {
        String[] parts = s.split("-");
        for (String part : parts) {
            if(part.contains(keyword))
                return part;
        }
        
        return null;
    }
    private static String lookForKeyword2(String message, String keyword) {
        //System.out.println("Looking for keyword \"" + keyword + "\" in string \"" + message + "\"");
        String pattern = "^.*?-?([^-]*" + keyword +"[^-]*)-?.*$";
        Matcher matcher = Pattern.compile(pattern).matcher(message);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        
        return null;
    }

    
	public static void main(String[] args) {
		
// Way 1
System.out.println("Way 1 ==============================================================");
		
        lookForKeyword("59USD-300kg-25mb_4G-48p/min(Incl. tax)-70y-2gb+1gb_Toffee-1km(mm/hr)", "gb");


// Way 2	
System.out.println("Way 2 ==============================================================");
        
        String[] strs = {
        	    "59USD-300kg-25mb_4G-48p/min(Incl. tax)-70y-2gb+1gb_Toffee-1km(mm/hr)",
        	    "59USD-300kg-25mb_4G-48p/min(Incl. tax)-70y-2gb+1gb_Toffee",
        	    "59USD-300kg-25mb_4G-48p/min(Incl. tax)-70y",
        	    "59USD-300kg-25mb_4G-48p/min(Incl. tax)",
        	    "59USD-300kg-25mb_4G",
        	    "59USD-300kg",
        	    "59USD"
        	};
        	Pattern data = Pattern.compile("(?<USD>[^-]+)(-(?<kg>[^-]+)(-(?<mb>[^-]+)(-(?<min>[^-]+)(-(?<y>[^-]+)(-(?<gb>[^-]+)(-(?<km>[^-]+))?)?)?)?)?)?");
        	for (String str : strs) {
        	    Matcher m = data.matcher(str);
        	    if (m.matches()) {
        	        System.out.println(str);
        	        System.out.println("\tUSD:\t" + m.group("USD"));
        	        System.out.println("\tkg :\t" + m.group("kg"));
        	        System.out.println("\tmb :\t" + m.group("mb"));
        	        System.out.println("\tmin:\t" + m.group("min"));
        	        System.out.println("\ty  :\t" + m.group("y"));
        	        System.out.println("\tgb :\t" + m.group("gb"));
        	        System.out.println("\tkm :\t" + m.group("km"));
        	        System.out.println("----");
        	    }
        	}

        	
// Way 3	
System.out.println("Way 3 ==============================================================");
        	
            String s ="59USD-300kg-25mb_4G-48p/min(Incl. tax)-70y-2gb+1gb_Toffee-65USD-1km(mm/hr)";
            
            long start=System.currentTimeMillis();
            for(int i=0; i<10000000; i++) {
                lookForKeyword2(s, "USD");
            }
            System.out.println("Elapsed ms: " + (System.currentTimeMillis()-start));
            
            start=System.currentTimeMillis();
            for(int i=0; i<10000000; i++) {
                getFirstKeywordMatch(s, "USD");
            }
            System.out.println("Elapsed ms: " + (System.currentTimeMillis()-start));
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
	}
	

    
    
    
    

}
