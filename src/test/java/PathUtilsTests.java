import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Constants;
import utils.PathUtils;

class PathUtilsTests {
	@ParameterizedTest
	@ValueSource(strings = {"menu.png"})
	void getFilePathFromResourcesFolder_ShouldReturnFilePath_WhenFileExists(String filename) {
		// TODO - Move to the test resources folder
		String expected = PathUtils.getFilePathFromResourcesFolder(Constants.MAIN_RESOURCES_PATH, filename);

		Assertions.assertTrue(expected.contains(filename));
	}
}
