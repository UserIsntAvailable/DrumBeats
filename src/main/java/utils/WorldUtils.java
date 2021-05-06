package utils;

import core.Config;
import graphics.ShapeDrawer;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class WorldUtils {
	private static Config config = Config.getInstance();

	public WorldUtils(Config config) {
		WorldUtils.config = config;
	}

	public static GreenfootImage createWorldBackground(Color color) {
		return ShapeDrawer.Rectangle(
				config.getValue("APP_WIDTH"),
				config.getValue("APP_HEIGHT"),
				color,
				"", null, null);
	}
}
