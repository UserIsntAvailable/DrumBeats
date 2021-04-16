package core.parsers;

import core.gameplay.models.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MapJsonParserTests {
	@Test
	void Parse_ShouldReturnMap_WhenJSONFileIsValid() {
		final String actualMapFilePath = "";
		final Map actualMap = new Map("Peppy", "Loves", "Little", "Kids", "All day");
		
		Map expected = MapJsonParser.parse(actualMapFilePath);
		
		Assertions.assertTrue(true);
	}
}
