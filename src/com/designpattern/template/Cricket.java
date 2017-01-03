package com.designpattern.template;

public class Cricket extends Game {

	@Override
	public void initialize() {
		System.out.println("Initializing cricket...");
	}

	@Override
	public void startPlay() {
		System.out.println("Playing cricket...");
	}

	@Override
	public void endPlay() {
		System.out.println("Ending cricket...");
	}

}
