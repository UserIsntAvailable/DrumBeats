package utils;

import core.Constants;
import graphics.ShapeDrawer;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class WorldUtils {
	public WorldUtils() {
	}

	public static GreenfootImage createWorldBackground(Color color) {
		return ShapeDrawer.Rectangle(
				Constants.APP_WIDTH, Constants.APP_HEIGHT, color,
				"", null, null);
	}
}
