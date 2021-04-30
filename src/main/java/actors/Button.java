package actors;

import graphics.ShapeDrawer;
import greenfoot.*;
import models.Map;
import parsers.MapJsonParser;
import utils.PathUtils;
import worlds.PlayField;


public class Button extends Actor {
	// I will keep the image just in case that I need it later
	private final GreenfootImage _image;

	public Button(int width, int height, Color background,
	              String text, Font font, Color textColor) {
		_image = ShapeDrawer.Rectangle(width, height, background, text, font, textColor);

		setImage(_image);
	}

	public void act() {
		if (Greenfoot.mouseClicked(this)) {
			// TODO - Refactor this into a Event Listener that changes the actors on screen depending on what button is clicked
			
			// Testing of course
			String mapFilePath = PathUtils.getMapFromResources(
					"4a6c00e3-06d8-4b48-babc-7ba32060252c",
					"7d1c794f-78d7-4589-aa1e-35651932771b.map"
			);
			Map map = MapJsonParser.parse(mapFilePath);

			Greenfoot.setWorld(new PlayField(map));
		}
	}
}
