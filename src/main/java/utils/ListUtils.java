package utils;

import actors.NoteActor;
import enums.DrumType;
import javafx.util.Pair;
import models.NoteModel;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
	public ListUtils() {
	}

	public static Collection<NoteActor> mapToNoteActor(List<NoteModel> noteModel) {
		return noteModel.stream()
				.map(NoteActor::new)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	public static List<String> mapToKeyStrings(List<Pair<DrumType, String>> drumKeys) {
		return drumKeys.stream()
				.map(Pair::getValue)
				.collect(Collectors.toList());
	}
}
