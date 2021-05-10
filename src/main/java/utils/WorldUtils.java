package utils;

import core.Config;
import graphics.ShapeDrawer;
import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.core.Simulation;
import greenfoot.core.WorldHandler;

public class WorldUtils {
	private static Config config = Config.getInstance();

	public WorldUtils(Config config) {
		WorldUtils.config = config;
	}

	public static GreenfootImage createWorldBackground(Color color) {
		return ShapeDrawer.RectangleWithoutText(
				config.getValue("APP_WIDTH"),
				config.getValue("APP_HEIGHT"),
				color
		);
	}

	/**
	 * Change the current world of the greenfoot scene.
	 * I use this because I wanted to call the stopped method of worlds
	 * automatically and I need some workarounds to achieve it.
	 *
	 * @param from The world that called the method ( I need it to discard it )
	 * @param to   The world that will be set.
	 */
	public static void setWorld(World from, World to) {
		var wh = WorldHandler.getInstance();

		wh.fireWorldRemovedEvent(from);

		// When fireWorldRemovedEvent is called the simulation is paused.
		Simulation.getInstance().setPaused(false);

		wh.setWorld(to, true);
	}
}
