import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.PathUtils;

class PathUtilsTests {
	@ParameterizedTest
	@ValueSource(strings = {"menu.png"})
	void getFilePathFromResourcesFolder_ShouldReturnFilePath_WhenFileExists(String filename) {
		String expected = PathUtils.getFilePathFromResourcesFolder(filename);

		Assertions.assertTrue(expected.contains(filename));
	}
}
