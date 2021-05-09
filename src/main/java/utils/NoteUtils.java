package utils;

import core.Config;
import enums.DrumType;
import enums.NoteType;
import enums.TaikoNote;
import models.NoteModel;

import java.util.List;

public class NoteUtils {
	private static Config config = Config.getInstance();

	public NoteUtils(Config config) {
		NoteUtils.config = config;
	}

	public static boolean isBigNote(NoteModel note) {
		return note.getParams().split(",")[0].equals("1");
	}

	public static double getNoteDiameter(NoteModel note) {
		if (isBigNote(note)) {
			return config.getValue(Integer.class, "NOTES_DIAMETER")
					* config.getValue(Double.class, "BIG_NOTES_MULTIPLIER");
		}
		return config.getValue(Integer.class, "NOTES_DIAMETER");
	}

	public static double getNoteOffsetTime(NoteModel note) {
		var noteSpawnPosition = config.getValue(Integer.class, "APP_WIDTH")
				+ (NoteUtils.getNoteDiameter(note) / 2);

		var noteTravelDistance = noteSpawnPosition
				- config.getValue(Integer.class, "NOTE_CATCHER_X_POSITION");

		return noteTravelDistance / config.getValue(Double.class, "NOTES_MOVEMENT_SPEED");
	}

	/**
	 * Get the keys that should be pressed to count as a good hit for that note.
	 */
	public static List<String> getNoteKeys(NoteModel note) {
		if (note.getTaikoNote().equals(TaikoNote.SLIDER))
			return ListUtils.mapToKeyStrings(config.getValue("APP_DRUM_KEYS"));

		return AppUtils.getDrumKeys(getDrumType(note));
	}

	public static DrumType getDrumType(NoteModel note) {
		return note.getNoteType().contains(NoteType.KAT) ? DrumType.OUTER : DrumType.INNER;
	}
}
