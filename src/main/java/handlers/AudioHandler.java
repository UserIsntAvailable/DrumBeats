package handlers;

import greenfoot.GreenfootSound;

public class AudioHandler implements Handler {
	private final GreenfootSound audio;
	
	public AudioHandler(String filepath) {
		audio = new GreenfootSound(filepath);
		configure();
	}

	@Override
	public long start() {
		audio.play();
		
		return System.nanoTime();
	}

	@Override
	public void configure() {
		// I will not bother setting the audio for each sound
		audio.setVolume(20);
	}

	@Override
	public void close() {
		audio.stop();
	}
}
