package core.parsers;

import core.models.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.utils.Constants;
import core.utils.PathUtils;

class MapJsonParserTests {
	@Test
	void Parse_ShouldReturnMap_WhenJSONFileIsValid() {
		final String actualMapFilePath = PathUtils.getFilePathFromResourcesFolder(
				Constants.TEST_RESOURCES_PATH, "map_template.map");
		
		final Map actualMap = new Map(
				"Random",
				"Stuff",
				"Right",
				"Here",
				"ca2f76c6-a55e-11eb-bcbc-0242ac130002",
				"5a253e8e-4f5e-491b-8594-103284a4dd8d");

		Map expected = MapJsonParser.parse(actualMapFilePath);

		Assertions.assertEquals(expected, actualMap);
	}
}
