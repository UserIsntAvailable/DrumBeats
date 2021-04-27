package actors;

import enums.DrumType;
import graphics.ShapeDrawer;
import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Drum extends Actor {
	private final int width;
	private final int height;
	private final DrumType type;
	private final String key;
	private final GreenfootImage currentImage = this.getImage();

	public Drum(int width, int height, DrumType type, String key) {
		this.width = width;
		this.height = height;
		this.type = type;
		this.key = key;
	}

	@Override
	public void act() {
		if (Greenfoot.isKeyDown(key)) {
			// TODO - I need to set up a ImageCache and get the images
			// This is just for testing
			GreenfootImage image = ShapeDrawer.RectangleWithoutText(
					width, height, getColorByDrumType());

			if (!image.equals(currentImage)) {
				this.setImage(image);
			}
		}
		else {
			GreenfootImage image = ShapeDrawer.RectangleWithoutText(
					width, height, new Color(100, 100, 100, 50));

			if (!image.equals(currentImage)) {
				this.setImage(image);
			}
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
