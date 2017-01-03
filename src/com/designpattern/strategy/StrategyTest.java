package com.designpattern.strategy;

public class StrategyTest {
	public static void main(String[] args) {
		int num1 = 5, num2 = 3;

		Context addContext = new Context(new AddOperation());
		System.out.println(num1 + " + " + num2 + " = "
				+ addContext.executeStrategy(num1, num2));

		System.out.println();
		Context subContext = new Context(new SubOperation());
		System.out.println(num1 + " - " + num2 + " = "
				+ subContext.executeStrategy(num1, num2));

		System.out.println();
		Context mulContext = new Context(new MulOperation());
		System.out.println(num1 + " * " + num2 + " = "
				+ mulContext.executeStrategy(num1, num2));
	}
}
