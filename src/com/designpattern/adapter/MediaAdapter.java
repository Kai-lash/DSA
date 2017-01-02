package com.designpattern.adapter;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMediaPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equals("vlc")) {
			this.advancedMediaPlayer = new VlcPlayer();
		} else if (audioType.equals("mp4")) {
			this.advancedMediaPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String filename) {
		if (audioType.equals("vlc")) {
			advancedMediaPlayer.playVlc(filename);
		} else if (audioType.equals("mp4")) {
			advancedMediaPlayer.playMp4(filename);
		}

	}

}
