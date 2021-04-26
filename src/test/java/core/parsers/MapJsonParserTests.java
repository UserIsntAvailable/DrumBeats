package core.parsers;

import core.enums.NoteType;
import core.enums.TaikoNote;
import core.models.Map;
import core.models.Note;
import core.utils.Constants;
import core.utils.PathUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumSet;

class MapJsonParserTests {
	@Test
	void Parse_ShouldReturnMap_WhenJSONFileIsValid() {
		final String actualMapFilePath = PathUtils.getFilePathFromResourcesFolder(
				Constants.TEST_RESOURCES_PATH, "map_template.map");

		final ArrayList<Note> actualNotes = new ArrayList<>();
		actualNotes.add(new Note(2000,
				TaikoNote.CIRCLE,
				EnumSet.of(NoteType.DON),
				"0,"));
		actualNotes.add(new Note(4000,
				TaikoNote.SLIDER,
				EnumSet.of(NoteType.KAT),
				"1,7000,"));
		actualNotes.add(new Note(8000,
				TaikoNote.SPINNER,
				EnumSet.of(NoteType.DON, NoteType.KAT),
				"10000,"));

		final Map actual = new Map(
				"Random",
				"Stuff",
				"Right",
				"Here",
				"ca2f76c6-a55e-11eb-bcbc-0242ac130002",
				"5a253e8e-4f5e-491b-8594-103284a4dd8d",
				actualNotes
		);

		Map expected = MapJsonParser.parse(actualMapFilePath);

		Assertions.assertEquals(expected, actual);
	}
}
