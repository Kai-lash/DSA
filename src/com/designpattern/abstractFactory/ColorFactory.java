package com.designpattern.abstractFactory;

public class ColorFactory implements AbstractFactory {

	@Override
	public Shape getShape(String shape) {
		return null;
	}

	@Override
	public Color getColor(String color) {
		if(color.equalsIgnoreCase("BLUE")){
			return new Blue();
		}else if(color.equalsIgnoreCase("GREEN")){
			return new Green();
		}else if(color.equalsIgnoreCase("RED")){
			return new Red();
		}else{
			return null;	
		} 
	}
}
