package com.designpattern.command;

public class Stock {
	private String name;
	private int quantity;

	public Stock(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public void buy() {
		System.out.println("Bought " + quantity + " stocks of " + name);
	}

	public void sell() {
		System.out.println("Sold " + quantity + " stocks of " + name);
	}
}
