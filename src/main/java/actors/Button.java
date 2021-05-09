package actors;

import core.Action;
import graphics.ShapeDrawer;
import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.Greenfoot;


public class Button extends Actor {
	private final Action action;

	public Button(int width, int height, Color background, String text, Font font, Color textColor, Action action) {
		setImage(ShapeDrawer.Rectangle(width, height, background, text, font, textColor));
		this.action = action;
	}

	public void act() {
		if (Greenfoot.mouseClicked(this)) {
			action.execute();
		}
	}
}
