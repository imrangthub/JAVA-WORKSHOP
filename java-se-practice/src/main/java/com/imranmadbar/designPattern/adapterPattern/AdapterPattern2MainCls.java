package com.imranmadbar.designPattern.adapterPattern;

interface Duck {
	void startShout();
}

class  SwanDuck implements Duck{
	public void startShout() {
		System.out.println("Pa Pa ....");
	}
}

class  AsinDuck implements Duck{
	public void startShout() {
		System.out.println("Pack Pack ....");
	}
}


class Turkey {
	void startShout() {
		System.out.println("Ka ka ka ....");
	}
}

class TurkeyAdapter implements Duck {
	
    private Turkey t;

    public TurkeyAdapter(Turkey t){
        this.t = t;
    }
    
    public void startShout() {
        t.startShout();
    }
    
}




class DuckCatcher{
    public void duchCath(Duck duck) { 
    	duck.startShout();
    }    
}


public class AdapterPattern2MainCls {

	public static void main(String[] args) {

		System.out.println("AdapterPatternMainCls");
		
		DuckCatcher duckCatcher = new DuckCatcher();
		AsinDuck asinDack = new AsinDuck(); 
		SwanDuck suwDack = new SwanDuck(); 
		
		Turkey turkeyObj = new Turkey(); 
		
		TurkeyAdapter trAdp = new TurkeyAdapter(turkeyObj);
		
	
		duckCatcher.duchCath(suwDack);
			
		
	}
	
	

}


