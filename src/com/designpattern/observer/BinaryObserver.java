package com.designpattern.observer;

public class BinaryObserver implements Observer {

	private Subject subject;

	public BinaryObserver(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		System.out.println("State change observed by binary observer : "
				+ Integer.toBinaryString(subject.getState()));
	}

}
