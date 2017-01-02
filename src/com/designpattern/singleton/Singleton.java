package com.designpattern.singleton;

public class Singleton {
	private static Singleton singleton = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return singleton;
	}
	
	public void show(){
		System.out.println("This is the singleton instance!");
	}
}
