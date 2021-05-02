package utils;

import actors.NoteActor;
import enums.TaikoNote;
import models.NoteModel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NotesListUtils {
	public NotesListUtils() {
	}

	public static Collection<NoteActor> mapToNoteActor(List<NoteModel> noteModel, int diameter) {

		return noteModel.stream()
				.map(note -> {
							if (note.getTaikoNote() != TaikoNote.SPINNER) {
								if (NoteUtils.isBigNote(note)) {
									return new NoteActor(diameter * 2, note);
								}
								return new NoteActor(diameter, note);

							}
							return null;
						}
				)
				.collect(Collectors.toCollection(LinkedList::new));
	}
}
