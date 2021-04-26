package core.parsers;

import core.enums.NoteType;
import core.enums.TaikoNote;
import core.utils.EnumUtils;
import org.json.*;
import core.models.Map;
import core.models.Note;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class MapJsonParser {
	public MapJsonParser() {
	}

	public static Map parse(String jsonFilePath) {
		String jsonText = "";
		try (Scanner scanner = new Scanner(new FileReader(jsonFilePath))) {
			StringBuilder sb = new StringBuilder();
			while (scanner.hasNext()) {
				sb.append(scanner.next());
			}
			jsonText = sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		JSONObject obj = new JSONObject(jsonText);

		return new Map(
				obj.getString("Name"),
				obj.getString("Artist"),
				obj.getString("SongFileName"),
				obj.getString("BackgroundFileName"),
				obj.getString("ID"),
				obj.getString("SetID"),
				parseNoteSection(obj.getJSONArray("Notes")));
	}

	private static ArrayList<Note> parseNoteSection(JSONArray jsonArray) {
		var returned = new ArrayList<Note>();

		for (var i = 0; i < jsonArray.length(); i++) {
			var note = jsonArray.getJSONObject(i);

			returned.add(
					new Note(
							note.getInt("Time"),
							EnumUtils.getEnumFromConstantValue(TaikoNote.class, note.getInt("TaikoNote")),
							EnumUtils.getEnumValuesFromFlag(NoteType.class, note.getInt("NoteType")),
							note.getString("Params")
					)
			);
		}

		return returned;
	}
}
