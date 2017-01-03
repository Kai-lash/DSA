package com.designpattern.observer;

public class OctalObserver implements Observer {

	private Subject subject;

	public OctalObserver(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		System.out.println("State change observed by octal observer : "
				+ Integer.toOctalString(subject.getState()));
	}

}
