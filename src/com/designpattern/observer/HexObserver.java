package com.designpattern.observer;

public class HexObserver implements Observer {

	private Subject subject;

	public HexObserver(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		System.out.println("State change observed by hex observer : "
				+ Integer.toHexString(subject.getState()));
	}

}
