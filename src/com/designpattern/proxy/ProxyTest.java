package com.designpattern.proxy;

public class ProxyTest {
	public static void main(String[] args) {
		Image image = new ProxyImage("UR.jpg");
		image.display(); //Image loaded from disk and displayed
		
		System.out.println();
		image.display(); //Displaying already loaded image
	}
}
