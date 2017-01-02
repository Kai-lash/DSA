package com.designpattern.singleton;

public class SingletonTest {
	
	public static void main(String[] args) {
		
		Singleton singleton = Singleton.getInstance();
		singleton.show();
		
	}
}
