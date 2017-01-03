package com.designpattern.command;

public class CommandTest {
	public static void main(String[] args) {
		Stock stock = new Stock("Google", 10);
		BuyStock buyStock = new BuyStock(stock);
		SellStock sellStock = new SellStock(stock);

		Broker broker = new Broker();
		broker.takeOrder(buyStock);
		broker.takeOrder(sellStock);

		broker.placeOrders();
	}
}
