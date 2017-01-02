package com.designpattern.factory;

public class ShapeFactory {
	private String SQUARE = "SQUARE";
	private String CIRCLE = "CIRCLE";
	private String RECTANGLE = "RECTANGLE";
	
	public Shape getShape(String shape){
		if(shape.equalsIgnoreCase(SQUARE)){
			return new Square();
		}else if(shape.equalsIgnoreCase(CIRCLE)){
			return new Circle();
		}else if(shape.equalsIgnoreCase(RECTANGLE)){
			return new Rectangle();
		}else{
			return null;
		}
	}
}
