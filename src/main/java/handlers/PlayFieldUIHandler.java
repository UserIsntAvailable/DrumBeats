package handlers;

import actors.Drum;
import actors.ImageHolder;
import actors.NoteCatcher;
import core.Config;
import enums.DrumType;
import graphics.ShapeDrawer;
import greenfoot.Color;
import greenfoot.World;
import javafx.util.Pair;

import java.util.List;

/**
 * Class that handles the static UI objects ( Actors that are always the same ) of the {@link worlds.PlayField}
 */
public class PlayFieldUIHandler implements Handler {
	//region Private Fields
	private final World world;
	private final NoteHandler noteHandler;
	private final ScoreHandler scoreHandler;
	private final Config config = Config.getInstance();
	//endregion

	//region Constructor
	public PlayFieldUIHandler(World world) {
		this.world = world;
		this.noteHandler = new NoteHandler();
		this.scoreHandler = new ScoreHandler(world);
		configure();
	}
	//endregion

	//region Handler
	public long start() {
		addDesignActors();
		addDrumsButtons();
		scoreHandler.start();
		return noteHandler.start();
	}

	public void configure() {
		config.setValue("NOTE_CATCHER_X_POSITION", world.getWidth() / 4);
		config.setValue("ACTORS_Y_POSITION", world.getHeight() / 2 + world.getHeight() / 20);
		config.setValue("NOTES_DIAMETER", config.getValue(Integer.class, "APP_WIDTH") / 20);
	}

	public void close() {
		noteHandler.close();
	}
	//endregion

	//region Private Methods
	private void addDesignActors() {
		// Notes rail
		world.addObject(
				new ImageHolder(ShapeDrawer.RectangleWithoutText(
						world.getWidth(),
						world.getHeight() / 5,
						new Color(80, 80, 80, 60))),
				world.getWidth() / 2,
				config.getValue("ACTORS_Y_POSITION")
		);

		world.addObject(
				new NoteCatcher(config.getValue(Integer.class, "NOTES_DIAMETER") + 10),
				config.getValue("NOTE_CATCHER_X_POSITION"),
				config.getValue("ACTORS_Y_POSITION")
		);
	}

	private void addDrumsButtons() {
		var drumKeys = (List<Pair<DrumType, String>>) config.getValue("APP_DRUM_KEYS");

		int xPosition = world.getWidth() / 18;
		int width = world.getWidth() / 32;
		int height = world.getHeight() / 7;
		int padding = world.getWidth() / 25;

		for (int i = 0; i <= drumKeys.size() - 1; i++) {
			DrumType drumType = drumKeys.get(i).getKey();
			String key = drumKeys.get(i).getValue();
			world.addObject(
					new Drum(width, height, drumType, key),
					xPosition + padding * i,
					config.getValue("ACTORS_Y_POSITION")
			);
		}
	}
	//endregion
}
