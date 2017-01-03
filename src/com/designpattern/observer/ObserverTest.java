package com.designpattern.observer;

public class ObserverTest {
	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer binaryObserver = new BinaryObserver(subject);
		Observer octalObserver = new OctalObserver(subject);
		Observer hexObserver = new HexObserver(subject);

		subject.attach(binaryObserver);
		subject.attach(octalObserver);
		subject.attach(hexObserver);

		subject.setState(15);
	}
}
