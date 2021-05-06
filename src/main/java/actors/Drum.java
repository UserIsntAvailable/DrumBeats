package actors;

import IO.KeyboardManager;
import enums.DrumType;
import graphics.ShapeDrawer;
import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.GreenfootSound;

import java.util.Locale;

public class Drum extends Actor {
	private final int width;
	private final int height;
	private final DrumType type;
	private final String key;

	public Drum(int width, int height, DrumType type, String key) {
		this.width = width;
		this.height = height;
		this.type = type;
		this.key = key;
	}

	@Override
	public void act() {
		GreenfootImage image;
		if (KeyboardManager.isKeyDown(key)) {
			/*
			 BUG - The hitsound plays twice because the isKeyDown is not fast enough
			   to false the key before the next frame happens ( as a solution I can just
			    create an instance of KeyboardManager for each object that needs it.... )
			 */
			playHitsound();
			// TODO - I need to set up a ImageCache and get the images
			// This is just for testing
			image = ShapeDrawer.RectangleWithoutText(
					width, height, getColorByDrumType());
		}
		else {
			image = ShapeDrawer.RectangleWithoutText(
					width, height, new Color(100, 100, 100, 50));
		}

		this.setImage(image);
	}

	private void playHitsound() {
		var hitSound = new GreenfootSound("drum-" + type.name().toLowerCase(Locale.ENGLISH) + "-hitsound.wav");
		hitSound.setVolume(70);
		hitSound.play();
	}

	private Color getColorByDrumType() {
		switch (type) {
			case INNER:
				return Color.RED;
			case OUTER:
				return Color.BLUE;
		}
		return null;
	}
}
