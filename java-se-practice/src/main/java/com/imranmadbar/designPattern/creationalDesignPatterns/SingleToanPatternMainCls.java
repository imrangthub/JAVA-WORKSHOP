package com.imranmadbar.designPattern.creationalDesignPatterns;

class Singleton {
	
	private static Singleton instance = null;
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

}

public class SingleToanPatternMainCls {

	public static void main(String[] args) {

		Singleton inst1 = Singleton.getInstance();
		System.out.println(inst1);
		Singleton inst2 = Singleton.getInstance();
		System.out.println(inst2);
		Singleton inst3 = Singleton.getInstance();
		System.out.println(inst3);

	}

}
