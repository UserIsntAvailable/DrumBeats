package utils;

import core.Config;
import models.NoteModel;

public class NoteUtils {
	public static Config config = Config.getInstance();

	public NoteUtils() {
	}

	public static boolean isBigNote(NoteModel note) {
		return note.getParams().split(",")[0].equals("1");
	}

	public static double getNoteDiameter(NoteModel note) {
		if (isBigNote(note)) {
			return config.getValue(Integer.class, "NOTES_DIAMETER")
					* config.getValue(Double.class, "BIG_NOTES_MULTIPLIER");
		}
		return config.getValue(Integer.class,"NOTES_DIAMETER");
	}

	public static double getNoteOffsetTime(NoteModel note) {
		var noteSpawnPosition = config.getValue(Integer.class, "APP_WIDTH")
				+ (NoteUtils.getNoteDiameter(note) / 2);

		var noteTravelDistance = noteSpawnPosition
				- config.getValue(Integer.class, "NOTE_CATCHER_X_POSITION");

		return noteTravelDistance / config.getValue(Double.class, "NOTES_MOVEMENT_SPEED");
	}
}
