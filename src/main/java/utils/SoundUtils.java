package utils;

import greenfoot.GreenfootSound;

public class SoundUtils {
	public SoundUtils() {
	}
	
	public static void playSound(String filename, int volume) {
		var sound = new GreenfootSound(filename);
		sound.setVolume(volume);
		sound.play();
	}
}
