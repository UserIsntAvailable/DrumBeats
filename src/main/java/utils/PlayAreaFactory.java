package utils;

import core.gameplay.models.Map;
import core.graphics.Drawable;
import greenfoot.Color;
import greenfoot.World;

public class PlayAreaFactory {
	public PlayAreaFactory() {
	}

	// TODO - I need unit testing when I finish to implement this
	public static World createPlayAreaWorldFromMap(Map map) {

		// TODO - If map is null create dummy map

		World playAreaWorld = new World(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT,
				1, false) {
		};

		playAreaWorld.setBackground(WorldUtils.createWorldBackground(Color.BLACK));

		// TODO - Parse the map, and the objects to the world

		return playAreaWorld;
	}
}
