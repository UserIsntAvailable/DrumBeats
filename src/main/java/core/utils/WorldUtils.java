package core.utils;

import core.graphics.Drawable;
import greenfoot.Color;
import greenfoot.GreenfootImage;

public class WorldUtils {
	public WorldUtils() {
	}

	public static GreenfootImage createWorldBackground(Color color) {
		return Drawable.DrawRectangle(
				Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, color,
				"", null, null);
	}
}
