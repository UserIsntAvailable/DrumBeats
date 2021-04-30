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

import java.util.List;
import java.util.Locale;

/**
 * Basically where the gameplay takes place.
 */
// TODO - Create handlers to separate all the functionality here ( I thought that it will be a good idea to have everything here but it is becoming a little bit chaotic )
public class PlayField extends World {
	//region Private Fields
	private final int currentNoteIndex = 0;
	private final long currentMillis = System.currentTimeMillis();
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

		configurePlayField();

		addUIActors();

		// Want to keep a empty play field even though the map is null
		if (map != null) {
			addNotesObjects(map.getNotes());
		}
	}
	//endregion

	//region Public Methods
	@Override
	public void act() {

	}
	//endregion

	//region Private Methods
	private void configurePlayField() {
		config.setValue(
				getClassName() + "ACTORS_Y_POSITION",
				this.getHeight() / 2 + 40
		);

		config.setValue(
				getClassName() + "NOTES_DIAMETER",
				60
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
				config.getValue(getClassName() + "ACTORS_Y_POSITION")
		);

		addDrumsButtons();

		addObject(
				new NoteCatcher(70),
				300,
				config.getValue(getClassName() + "ACTORS_Y_POSITION")
		);
	}

	private void addDrumsButtons() {
		// TODO - Be able to change the default keys, by creating a Config where all is stored
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
					this.getWidth() / 20 + padding * i,
					config.getValue(getClassName() + "ACTORS_Y_POSITION")
			);
		}
	}

	private void addNotesObjects(List<NoteModel> notes) {
		var noteDiameter = config.getValue(Integer.class, getClassName() + "NOTES_DIAMETER");
		for (var i = 0; i < notes.size() - 1; i++) {
			var note = notes.get(i);
			this.addObject(
					new NoteActor(noteDiameter, note),
					this.getWidth() + (noteDiameter / 2) + i,
					config.getValue(getClassName() + "ACTORS_Y_POSITION")
			);
		}
	}

	private String getClassName() {
		return this.getClass()
				.getSimpleName()
				.toUpperCase(Locale.ENGLISH);
	}
	//endregion
}
