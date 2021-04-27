package core.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import core.Constants;
import utils.PathUtils;

class PathUtilsTests {
	@ParameterizedTest
	@ValueSource(strings = {"menu.png", "PeppyMap.json"})
	void getFilePathFromResourcesFolder_ShouldReturnFilePath_WhenFileExists(String filename) {
		String expected = PathUtils.getFilePathFromResourcesFolder(Constants.TEST_RESOURCES_PATH, filename);

		Assertions.assertTrue(expected.contains(filename));
	}
}
