package actors;

import IO.KeyboardManager;
import core.Config;
import enums.DrumType;
import graphics.ShapeDrawer;
import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import utils.SoundUtils;

import java.util.Locale;

public class Drum extends Actor {
	private final int width;
	private final int height;
	private final DrumType type;
	private final String key;
	private final Config config = Config.getInstance();

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
			SoundUtils.playSound(
					"drum-" + type.name().toLowerCase(Locale.ENGLISH) + "-hitsound.wav",
					config.getValue("HITSOUNDS_BASE_VOLUME")
			);
			// TODO - I need to set up a ImageCache and get the images
			// This is just for testing
			image = ShapeDrawer.RectangleWithoutText(
					width, height, type.getColor());
		}
		else {
			image = ShapeDrawer.RectangleWithoutText(
					width, height, new Color(100, 100, 100, 50));
		}

		this.setImage(image);
	}
}
