package core.worlds;

import core.actors.Drum;
import core.actors.ImageHolder;
import core.enums.DrumType;
import core.graphics.Drawer;
import core.models.Map;
import core.utils.Constants;
import core.utils.WorldUtils;
import greenfoot.Color;
import greenfoot.World;

public class PlayField extends World {
	public PlayField(Map map) {
		super(Constants.APP_WIDTH, Constants.APP_HEIGHT, 1, true);

		addUIActors();

		// TODO - If map is null create dummy playField
		// TODO - Parse the map, and add the objects to this
	}

	private void addUIActors() {
		this.setBackground(WorldUtils.createWorldBackground(Color.BLACK));

		// Note rail
		this.addObject(
				new ImageHolder(Drawer.RectangleWithoutText(
						Constants.APP_WIDTH,
						Constants.APP_HEIGHT / 5,
						new Color(80, 80, 80, 60))),
				Constants.APP_WIDTH / 2,
				Constants.APP_HEIGHT / 2 + 40
		);

		addDrumsButtons();
	}

	private void addDrumsButtons() {
		// TODO - Be able to change the default keys
		// TODO - Refactor this with a for loop and a list of KeyValuePair

		int width = 40;
		int height = 100;

		this.addObject(
				new Drum(width, height,
						DrumType.OUTER, "d"),
				Constants.APP_WIDTH / 20,
				Constants.APP_HEIGHT / 2 + 40
		);

		this.addObject(
				new Drum(width, height,
						DrumType.INNER, "f"),
				Constants.APP_WIDTH / 20 + 50,
				Constants.APP_HEIGHT / 2 + 40
		);

		this.addObject(
				new Drum(width, height,
						DrumType.INNER, "j"),
				Constants.APP_WIDTH / 20 + 100,
				Constants.APP_HEIGHT / 2 + 40
		);

		this.addObject(
				new Drum(width, height,
						DrumType.OUTER, "k"),
				Constants.APP_WIDTH / 20 + 150,
				Constants.APP_HEIGHT / 2 + 40
		);
	}
}
