package com.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Broker {
	List<Order> orders = new ArrayList<>();

	public void takeOrder(Order order) {
		orders.add(order);
	}

	public void placeOrders() {
		for (Order order : orders) {
			order.execute();
		}
		orders.clear();
	}
}
