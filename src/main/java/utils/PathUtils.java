package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PathUtils {

	public PathUtils() {
	}

	public static String getFilePathFromResourcesFolder(String filename) {
		Path cwd = Paths
				// get current relative path
				.get("")
				// get current working directory
				.toAbsolutePath();

		// The cwd changes depending where the code was called for compilation.
		if (cwd.getFileName().toString().equals("java")) {
			for (int i = 0; i < 3; i++) {
				cwd = cwd.getParent();
			}
		}

		Path resourcesPath = cwd.resolve(Constants.MAIN_RESOURCES_PATH);

		String filePath = "";
		try (Stream<Path> stream = Files.walk(resourcesPath, Integer.MAX_VALUE)) {
			filePath = stream
					.filter(path -> path.getFileName().toString().equals(filename))
					.findFirst()
					.get()
					.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}
}
