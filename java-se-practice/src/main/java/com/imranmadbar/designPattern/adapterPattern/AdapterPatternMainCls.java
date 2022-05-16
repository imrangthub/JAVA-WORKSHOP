package com.imranmadbar.designPattern.adapterPattern;


interface Shape {
    public int calculateArea(int r);
}

class Square implements Shape {
	
    @Override
    public int calculateArea(int r) {
        return r * r;
    } 
}

class Circle {
    public double calculateCircularArea (int r) {
        return 3.14 * r * r;
    }
}

class CirCleAdaptor extends Circle implements Shape {
    @Override
    public int calculateArea(int r) {
        return (int) calculateCircularArea(r);
    }
}


class DrowArea {
	void drowIt(Shape shapeObj, int areaNum) {
		System.out.println(shapeObj.calculateArea(areaNum));
	}
}


public class AdapterPatternMainCls {
	
	  public static void main(String[] args) {
		  
	        Shape square = new Square();
	        Shape circle = new CirCleAdaptor();
	        
	        DrowArea drowObj = new DrowArea();
	        
	        drowObj.drowIt(circle, 5);
	        
	        

	    }

}
