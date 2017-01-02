package com.designpattern.adapter;

public class AudioPlayer implements MediaPlayer {
	
	MediaAdapter mediaAdapter;
	
	@Override
	public void play(String audioType, String filename) {
		if(audioType.equals("mp3")){
			System.out.println("Playing audio file. Name : " + filename);
		}else if (audioType.equals("vlc") || audioType.equals("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, filename);
		} 
		
	}

}
