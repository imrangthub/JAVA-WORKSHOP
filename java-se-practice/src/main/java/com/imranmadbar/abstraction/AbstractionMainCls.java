package com.imranmadbar.abstraction;



class Rectangle extends Shape {
	void draw() {
		System.out.println("Drawing Rectangle");
	}
}

class Circle extends Shape {
	void draw() {
		System.out.println("Drawing Circle");
	}
	
	public void printMsg() {
		System.out.println("Message from abstract cls of Circle");
	}
}


public class AbstractionMainCls {
	
	public static void main(String[] args) {
	
		
		Shape shapObj = new Circle();
		
		
		shapObj.draw();
		shapObj.printMsg();
		
		
		BiggerAbstraExtd2 bsObj = new BiggerAbstraExtd2();
		bsObj.abs3();
		
	}

}
