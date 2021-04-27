package worlds;

import actors.Drum;
import actors.ImageHolder;
import actors.NoteActor;
import actors.NoteCatcher;
import core.Config;
import enums.DrumType;
import graphics.ShapeDrawer;
import greenfoot.Color;
import greenfoot.World;
import javafx.util.Pair;
import models.Map;
import utils.WorldUtils;

import java.util.List;

public class PlayField extends World {
	private final long currentMillisecond = System.currentTimeMillis();

	private static final Config config = Config.getInstance();

	// I will be using this so much here that I think that this is worth it
	private static final int worldWidth = config.getValue(Integer.class, "APP_WIDTH");
	private static final int worldHeight = config.getValue(Integer.class, "APP_HEIGHT");

	public PlayField(Map map) {
		super(worldWidth, worldHeight, 1, false);

		addUIActors();

		var test = new NoteActor();
		test.setImage(ShapeDrawer.CircleWithoutText(60, Color.CYAN));

		this.addObject(
				test,
				worldWidth + 40,
				worldHeight / 2 + 40
		);

		// TODO - Parse the map, and add the objects to this
	}

	@Override
	public void act() {

	}

	private void addUIActors() {
		this.setBackground(WorldUtils.createWorldBackground(Color.BLACK));

		int yPosition = worldHeight / 2 + 40;

		// Notes rail
		this.addObject(
				new ImageHolder(ShapeDrawer.RectangleWithoutText(
						worldWidth,
						worldHeight / 5,
						new Color(80, 80, 80, 60))),
				worldWidth / 2,
				yPosition
		);

		addDrumsButtons(worldWidth / 20, yPosition);

		addObject(
				new NoteCatcher(70),
				300,
				yPosition
		);
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
