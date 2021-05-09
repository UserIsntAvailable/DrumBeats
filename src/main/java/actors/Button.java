package actors;

import core.Action;
import graphics.ShapeDrawer;
import graphics.Text;
import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.Greenfoot;


public class Button extends Actor {
	private final Action action;

	public Button(int width, int height, Color background, Text text, Action action) {
		setImage(ShapeDrawer.Rectangle(width, height, background, text));
		this.action = action;
	}

	public void act() {
		if (Greenfoot.mouseClicked(this)) {
			action.execute();
		}
	}
}
