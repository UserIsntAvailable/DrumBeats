package handlers;

import greenfoot.GreenfootSound;

public class AudioHandler implements Handler {
	//region Private Fields
	private final GreenfootSound audio;
	//endregion
	
	// region Constructor
	public AudioHandler(String filepath) {
		audio = new GreenfootSound(filepath);
		configure();
	}
	//endregion

	//region Handler
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
	//endregion
}
