package com.designpattern.decorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape shape) {
		super(shape);
	}
	
	public void setRedBorder(Shape shape){
		System.out.println("Setting red border...");
	}

}
