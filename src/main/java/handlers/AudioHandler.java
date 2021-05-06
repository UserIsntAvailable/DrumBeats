package handlers;

import greenfoot.GreenfootSound;

public class AudioHandler implements Handler {
	private final GreenfootSound audio;
	
	public AudioHandler(String filepath) {
		audio = new GreenfootSound(filepath);
	}

	@Override
	public long start() {
		audio.play();
		
		return System.nanoTime();
	}

	@Override
	public void configure() {
	}

	@Override
	public void close() {
		audio.stop();
	}
}
