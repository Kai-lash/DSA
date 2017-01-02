package com.designpattern.abstractFactory;

public class AbstractFactoryTest {
	public static void main(String[] args) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
		
		Shape circle = shapeFactory.getShape("CIRCLE");
		Shape square = shapeFactory.getShape("SQUARE");
		Shape rectangle = shapeFactory.getShape("RECTANGLE");
		circle.draw();square.draw();rectangle.draw();
		
		Color red = colorFactory.getColor("RED");
		Color blue = colorFactory.getColor("BLUE");
		Color green = colorFactory.getColor("GREEN");
		red.fill();green.fill();blue.fill();
		
	}
}
