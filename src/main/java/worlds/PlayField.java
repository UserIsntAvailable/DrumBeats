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
import models.NoteModel;
import utils.WorldUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Basically where the gameplay takes place.
 */
// TODO - Create handlers to separate all the functionality here ( I thought that it will be a good idea to have everything here but it is becoming a little bit chaotic )
public class PlayField extends World {
	//region Private Fields
	private Queue<NoteActor> notesQueue;
	private final long timeWhenCreated;
	private static final Config config = Config.getInstance();
	//endregion

	//region Constructor
	public PlayField(Map map) {
		super(
				config.getValue("APP_WIDTH"),
				config.getValue("APP_HEIGHT"),
				1,
				false
		);

		Menu.getInstance().getBgMusic().stop();

		configurePlayField();

		addUIActors();

		// Want to keep a empty play field even though the map is null
		if (map != null) {
			notesQueue = noteModelToNoteActor(map.getNotes());
		}

		timeWhenCreated = System.currentTimeMillis();
	}
	//endregion

	//region Public Methods
	@Override
	public void act() {
		if (notesQueue.size() > 0) {
			var time = System.currentTimeMillis() - timeWhenCreated;
			if (notesQueue.peek().getNoteModel().getTime() <= time) {

				var note = notesQueue.poll();

				this.addObject(
						note,
						this.getWidth() + config.getValue(Integer.class, "NOTES_DIAMETER") / 2,
						config.getValue("ACTORS_Y_POSITION")
				);
			}
		}
	}
	//endregion

	//region Private Methods
	private void configurePlayField() {
		config.setValue(
				"ACTORS_Y_POSITION",
				this.getHeight() / 2 + 40
		);

		config.setValue(
				"NOTES_DIAMETER",
				this.getWidth() / 21
		);
	}

	private void addUIActors() {
		this.setBackground(WorldUtils.createWorldBackground(Color.BLACK));

		// Notes rail
		this.addObject(
				new ImageHolder(ShapeDrawer.RectangleWithoutText(
						this.getWidth(),
						this.getHeight() / 5,
						new Color(80, 80, 80, 60))),
				this.getWidth() / 2,
				config.getValue("ACTORS_Y_POSITION")
		);

		addDrumsButtons();

		addObject(
				new NoteCatcher(config.getValue(Integer.class, "NOTES_DIAMETER") + 10),
				this.getWidth() / 4,
				config.getValue("ACTORS_Y_POSITION")
		);
	}

	private void addDrumsButtons() {
		// TODO - Be able to change the default keys ( I can save that info on the config )
		List<Pair<DrumType, String>> drumActors = List.of(
				new Pair<>(DrumType.OUTER, "d"),
				new Pair<>(DrumType.INNER, "f"),
				new Pair<>(DrumType.INNER, "j"),
				new Pair<>(DrumType.OUTER, "k")
		);

		int xPosition = this.getWidth() / 18;
		int width = this.getWidth() / 32;
		int height = this.getHeight() / 7;
		int padding = this.getWidth() / 25;

		for (int i = 0; i <= drumActors.size() - 1; i++) {
			DrumType actorKey = drumActors.get(i).getKey();
			String actorValue = drumActors.get(i).getValue();
			this.addObject(
					new Drum(width, height, actorKey, actorValue),
					xPosition + padding * i,
					config.getValue("ACTORS_Y_POSITION")
			);
		}
	}

	private Queue<NoteActor> noteModelToNoteActor(List<NoteModel> noteModel) {
		return noteModel.stream()
				.map(note -> new NoteActor(config.getValue("NOTES_DIAMETER"), note))
				.collect(Collectors.toCollection(LinkedList::new));
	}
	//endregion
}
