package utils;

import models.NoteModel;

public class NoteUtils {
	public NoteUtils() {
	}
	
	public static boolean isBigNote(NoteModel note) {
		return note.getParams().split(",")[0].equals("1");
	}
}
