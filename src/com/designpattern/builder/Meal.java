package com.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	private List<Item> items = new ArrayList<>();
	public void add(Item item){
		items.add(item);
	}
	
	public float getCost(){
		float cost = 0;
		for(Item item : items){
			cost += item.price();
		}
		return cost;
	}
	
	public void showItems(){
		for(Item item : items){
			System.out.println(item.name());
		}
		System.out.println("Total cost : " + getCost());
	}

}
