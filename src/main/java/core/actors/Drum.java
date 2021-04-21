package core.actors;

import core.enums.DrumType;
import core.graphics.Drawable;
import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Drum extends Actor {
	private final DrumType type;
	private final String key;
	private final GreenfootImage currentImage = this.getImage();

	public Drum(DrumType type, String key) {
		this.type = type;
		this.key = key;
	}

	@Override
	public void act() {
		if (Greenfoot.isKeyDown(key)) {
			// TODO - I need to set up a ImageCache and get the images
			// This is just for testing
			Color color = null;
			switch (type){
				case INNER:
					color = Color.RED;
					break;
				case OUTER:
					color = Color.BLUE;
					break;
			}
			GreenfootImage image = Drawable.DrawRectangle(
					40,100,color,
					"", null,null);
			
			if (!image.equals(currentImage)){
				this.setImage(image);
			}
		}
		else {
			GreenfootImage image = Drawable.DrawRectangle(
					40,100,
					new Color(100,100,100, 50),
					"", null,null);
			
			if (!image.equals(currentImage)) {
				this.setImage(image);
			}
		}
	}
}
