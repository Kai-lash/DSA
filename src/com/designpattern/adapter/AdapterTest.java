package com.designpattern.adapter;

public class AdapterTest {
	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "Fix you");
		audioPlayer.play("mp4", "Viva la vida");
		audioPlayer.play("vlc", "Talk");
	}
}
