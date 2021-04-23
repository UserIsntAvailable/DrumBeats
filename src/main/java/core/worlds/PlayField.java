package core.worlds;

import core.actors.Drum;
import core.actors.ImageHolder;
import core.enums.DrumType;
import core.graphics.ShapeDrawer;
import core.models.Map;
import core.utils.Constants;
import core.utils.WorldUtils;
import greenfoot.Color;
import greenfoot.World;
import javafx.util.Pair;

import java.util.List;

public class PlayField extends World {
	public PlayField(Map map) {
		super(Constants.APP_WIDTH, Constants.APP_HEIGHT, 1, true);

		addUIActors();

		// TODO - If map is null create dummy playField
		// TODO - Parse the map, and add the objects to this
	}

	private void addUIActors() {
		this.setBackground(WorldUtils.createWorldBackground(Color.BLACK));

		int yPosition = Constants.APP_HEIGHT / 2 + 40;

		// Notes rail
		this.addObject(
				new ImageHolder(ShapeDrawer.RectangleWithoutText(
						Constants.APP_WIDTH,
						Constants.APP_HEIGHT / 5,
						new Color(80, 80, 80, 60))),
				Constants.APP_WIDTH / 2,
				yPosition
		);

		addDrumsButtons(Constants.APP_WIDTH / 20, yPosition);
	}

	private void addDrumsButtons(int x, int y) {
		// TODO - Be able to change the default keys, by creating a Config where all is stored ( maybe rename Constants to Config? )
		List<Pair<DrumType, String>> drumActors = List.of(
				new Pair<>(DrumType.OUTER, "d"),
				new Pair<>(DrumType.INNER, "f"),
				new Pair<>(DrumType.INNER, "j"),
				new Pair<>(DrumType.OUTER, "k")
		);

		int width = 40;
		int height = 100;
		int padding = 50;

		for (int i = 0; i <= drumActors.size() - 1; i++) {
			DrumType actorKey = drumActors.get(i).getKey();
			String actorValue = drumActors.get(i).getValue();
			this.addObject(
					new Drum(width, height, actorKey, actorValue),
					x + padding * i, 
					y
			);
		}
	}
}
