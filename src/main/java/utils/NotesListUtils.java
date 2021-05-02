package utils;

import actors.NoteActor;
import core.Config;
import enums.TaikoNote;
import models.NoteModel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NotesListUtils {
	public static Config config = Config.getInstance();

	public NotesListUtils() {
	}

	public static Collection<NoteActor> mapToNoteActor(List<NoteModel> noteModel) {

		return noteModel.stream()
				.map(note -> {
							if (note.getTaikoNote() != TaikoNote.SPINNER) {
								if (NoteUtils.isBigNote(note)) {
									return new NoteActor(config.getValue(Integer.class, "NOTES_DIAMETER") * 2, note);
								}
								return new NoteActor(config.getValue("NOTES_DIAMETER"), note);

							}
							return null;
						}
				)
				.collect(Collectors.toCollection(LinkedList::new));
	}
}
