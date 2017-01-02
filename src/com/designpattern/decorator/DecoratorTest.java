package com.designpattern.decorator;

public class DecoratorTest {
	public static void main(String[] args) {
		Shape circle = new Circle();
		Shape rectangle = new Rectangle();
		RedShapeDecorator decoratedCircle = new RedShapeDecorator(circle);
		RedShapeDecorator decoratedRectangle = new RedShapeDecorator(rectangle);
		
		System.out.println("Drawing normal circle.");
		circle.draw();
		
		System.out.println("\nDrawing red circle.");
		decoratedCircle.draw();
		decoratedCircle.setRedBorder(circle);
		
		System.out.println("\nDrawing red rectangle.");
		decoratedRectangle.draw();
		decoratedRectangle.setRedBorder(rectangle);
	}
}
