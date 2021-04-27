package core.actors;

import core.graphics.ShapeDrawer;
import greenfoot.Actor;
import greenfoot.Color;

public class NoteCatcher extends Actor {
	public NoteCatcher(int diameter) {
		setImage(ShapeDrawer.CircleWithoutText(diameter, new Color(100, 100, 100, 50)));
	}

	@Override
	public void act() {
	}
}
