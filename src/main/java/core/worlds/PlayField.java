package core.worlds;

import core.actors.Drum;
import core.actors.ImageHolder;
import core.enums.DrumType;
import core.graphics.Drawable;
import core.models.Map;
import core.utils.Constants;
import core.utils.WorldUtils;
import greenfoot.Color;
import greenfoot.World;

public class PlayField extends World {
	
	public PlayField(Map map) {
		super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1, true);
		
		addUIActors();
		
		// TODO - If map is null create dummy playField
		// TODO - Parse the map, and add the objects to this
	}
	
	private void addUIActors() {
		this.setBackground(WorldUtils.createWorldBackground(Color.BLACK));
		
		// THis is very messy, refactoring later....
		
		int width = Constants.SCREEN_WIDTH;
		int height = Constants.SCREEN_HEIGHT;
		
		// Note rail
		this.addObject(
				new ImageHolder(Drawable.DrawRectangle(
						width,height / 5,
						new Color(80,80,80, 60),
						"",null,null)),
				width / 2,
				height / 2 + 40
		);

		addDrumsButtons(width, height);
	}

	private void addDrumsButtons(int width, int height) {
		// TODO - Be able to change the default keys
		// TODO - Refactor this with a for loop and a list of KeyValuePair
		
		this.addObject(
				new Drum(DrumType.OUTER, "d"),
				width / 20,
				height / 2 + 40
		);

		this.addObject(
				new Drum(DrumType.INNER, "f"),
				width / 20 + 50,
				height / 2 + 40
		);

		this.addObject(
				new Drum(DrumType.INNER, "j"),
				width / 20 + 100,
				height / 2 + 40
		);

		this.addObject(
				new Drum(DrumType.OUTER, "k"),
				width / 20 + 150,
				height / 2 + 40
		);
	}
}
