package com.designpattern.iterator;

public class NameRepository implements Container {

	private String[] names;
	private int index, addIndex, capacity;

	public NameRepository(int capacity) {
		this.capacity = capacity;
		names = new String[capacity];
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new Iterator() {

			@Override
			public String next() {
				return names[index++];
			}

			@Override
			public boolean hasNext() {
				if (index < capacity) {
					return true;
				}
				return false;
			}
		};
	}

	public void add(String name) {
		if (addIndex < capacity) {
			names[addIndex++] = name;
		}
	}

	public void clear() {
		names = new String[capacity];
		addIndex = 0;
	}
}
