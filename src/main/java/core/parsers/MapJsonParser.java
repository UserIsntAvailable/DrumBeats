package core.parsers;

import org.json.*;
import core.models.Map;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
				obj.getString("SongPath"),
				obj.getString("BackgroundPath")
		);
	}
}
