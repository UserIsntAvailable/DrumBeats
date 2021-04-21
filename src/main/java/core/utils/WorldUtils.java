package core.utils;

import core.graphics.Drawer;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class WorldUtils {
	public WorldUtils() {
	}

	public static GreenfootImage createWorldBackground(Color color) {
		return Drawer.Rectangle(
				Constants.APP_WIDTH, Constants.APP_HEIGHT, color,
				"", null, null);
	}
}
