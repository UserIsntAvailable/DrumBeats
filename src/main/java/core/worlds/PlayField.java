package core.worlds;

import core.models.Map;
import core.utils.Constants;
import core.utils.WorldUtils;
import greenfoot.Color;
import greenfoot.World;

public class PlayField extends World {
	
	public PlayField(Map map) {
		super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1, true);

		this.setBackground(WorldUtils.createWorldBackground(Color.BLACK));
		
		// TODO - If map is null create dummy playField
		// TODO - Parse the map, and add the objects to this
	}
}
