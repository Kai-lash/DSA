package com.designpattern.abstractFactory;

public interface AbstractFactory {
	public abstract Shape getShape(String shape);
	public abstract Color getColor(String color);
}
