package com.designpattern.facade;

public class ShapeMaker {
	Shape circle, square, rectangle;

	public ShapeMaker() {
		circle = new Circle();
		square = new Square();
		rectangle = new Rectangle();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawSquare() {
		square.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}
}
