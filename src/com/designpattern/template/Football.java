package com.designpattern.template;

public class Football extends Game {

	@Override
	public void initialize() {
		System.out.println("Initializing football...");
	}

	@Override
	public void startPlay() {
		System.out.println("Playing football...");
	}

	@Override
	public void endPlay() {
		System.out.println("Ending football...");
	}

}
