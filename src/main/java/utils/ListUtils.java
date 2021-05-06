package utils;

import actors.NoteActor;
import core.Config;
import enums.DrumType;
import enums.TaikoNote;
import javafx.util.Pair;
import models.NoteModel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
	private static Config config = Config.getInstance();

	public ListUtils(Config config) {
		ListUtils.config = config;
	}

	public static Collection<NoteActor> mapToNoteActor(List<NoteModel> noteModel) {
		return noteModel.stream()
				.map(note -> {
							if (note.getTaikoNote() != TaikoNote.SPINNER) {
								if (NoteUtils.isBigNote(note)) {
									return new NoteActor(
											(int) (
													config.getValue(Integer.class, "NOTES_DIAMETER") *
															config.getValue(Double.class, "BIG_NOTES_MULTIPLIER")
											),
											note
									);
								}
								return new NoteActor(config.getValue("NOTES_DIAMETER"), note);
							}
							return null;
						}
				).collect(Collectors.toCollection(LinkedList::new));
	}

	public static List<String> mapToKeyStrings(List<Pair<DrumType, String>> drumKeys) {
		return drumKeys.stream()
				.map(Pair::getValue)
				.collect(Collectors.toList());
	}
}
