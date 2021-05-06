package actors;

import IO.KeyboardManager;
import enums.DrumType;
import graphics.ShapeDrawer;
import greenfoot.*;

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
		if (KeyboardManager.isKeyDown(key)) {
			// TODO - I need to set up a ImageCache and get the images
			// This is just for testing
			GreenfootImage image = ShapeDrawer.RectangleWithoutText(
					width, height, getColorByDrumType());

			this.setImage(image);
		}
		else {
			GreenfootImage image = ShapeDrawer.RectangleWithoutText(
					width, height, new Color(100, 100, 100, 50));
			
			this.setImage(image);
		}
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
