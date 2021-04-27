package utils;

import core.Config;
import graphics.ShapeDrawer;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class WorldUtils {
	public WorldUtils() {
	}

	public static GreenfootImage createWorldBackground(Color color) {
		return ShapeDrawer.Rectangle(
				Config.APP_WIDTH, Config.APP_HEIGHT, color,
				"", null, null);
	}
}
