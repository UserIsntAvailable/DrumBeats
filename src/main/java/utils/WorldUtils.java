package utils;

import core.Config;
import graphics.ShapeDrawer;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class WorldUtils {
	private static final Config config = Config.getInstance();

	public WorldUtils() {
	}

	public static GreenfootImage createWorldBackground(Color color) {
		return ShapeDrawer.Rectangle(
				config.getValue(Integer.class, "APP_WIDTH"),
				config.getValue(Integer.class, "APP_HEIGHT"),
				color,
				"", null, null);
	}
}
