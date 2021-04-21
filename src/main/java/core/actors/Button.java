package core.actors;

import core.graphics.Drawer;
import core.worlds.PlayField;
import greenfoot.*;

import java.util.function.Consumer;


public class Button extends Actor {
	// I will keep the image just in case that I need it later
	private final GreenfootImage _image;
	private final Consumer<World> _action;

	public Button(int width, int height, Color background,
	              String text, Font font, Color textColor,
	              Consumer<World> action) {
		_action = action;
		_image = Drawer.Rectangle(width, height, background, text, font, textColor);

		setImage(_image);
	}

	public void act() {
		if (Greenfoot.mouseClicked(this)) {
			// TODO - Refactor this into a Event Listener that changes the actors on screen depending on what button is clicked
			_action.accept(new PlayField(null));
		}
	}
}
