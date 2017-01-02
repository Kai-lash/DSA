package com.designpattern.proxy;

public class RealImage implements Image {

	private String filename;

	public RealImage(String filename) {
		this.filename = filename;
		loadImageFromDisk();
	}

	@Override
	public void display() {
		System.out.println("Displaying image " + filename);
	}

	public void loadImageFromDisk() {
		System.out.println("Loading image from disk " + filename);
	}

}
