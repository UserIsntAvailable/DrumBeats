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
		return config.getValue("NOTES_DIAMETER");
	}
}
