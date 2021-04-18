package core.parsers;

import core.models.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.utils.Constants;
import core.utils.PathUtils;

class MapJsonParserTests {
	@Test
	void Parse_ShouldReturnMap_WhenJSONFileIsValid() {
		final String actualMapFilePath = PathUtils.getFilePathFromResourcesFolder(Constants.TEST_RESOURCES_PATH, "PeppyMap.json");
		final Map actualMap = new Map(
				"Peppy",
				"Loves",
				"Little",
				"Kids"
		);

		Map expected = MapJsonParser.parse(actualMapFilePath);

		Assertions.assertEquals(expected, actualMap);
	}
}
