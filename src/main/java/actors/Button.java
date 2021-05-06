package actors;

import graphics.ShapeDrawer;
import greenfoot.*;
import models.Map;
import parsers.MapJsonParser;
import utils.PathUtils;
import worlds.PlayField;


public class Button extends Actor {
	// I will keep the image just in case that I need it later
	private final GreenfootImage image;

	public Button(int width, int height, Color background,
	              String text, Font font, Color textColor) {
		image = ShapeDrawer.Rectangle(width, height, background, text, font, textColor);

		setImage(image);
	}

	public void act() {
		if (Greenfoot.mouseClicked(this)) {
			// TODO - Refactor this into a Event Listener that changes the actors on screen depending on what button is clicked
			
			// Testing of course
			String mapFilePath = PathUtils.getResourceFromMap(
					"b82af975-4d44-4608-b686-70d61851508d",
					"7b9ac868-675d-4e53-bb84-2305290fbf63.map"
			);
			Map map = MapJsonParser.parse(mapFilePath);

			Greenfoot.setWorld(new PlayField(map));
		}
	}
}
