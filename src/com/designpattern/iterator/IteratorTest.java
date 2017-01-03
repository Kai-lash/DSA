package com.designpattern.iterator;

public class IteratorTest {
	public static void main(String[] args) {
		NameRepository names = new NameRepository(5);
		names.add("A");
		names.add("B");
		names.add("C");
		names.add("D");
		names.add("E");
		Iterator iterator = names.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
