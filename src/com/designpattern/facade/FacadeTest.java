package com.designpattern.facade;

public class FacadeTest {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawSquare();
		shapeMaker.drawRectangle();
	}
}
