package utils;

import java.util.Objects;

public class PathUtils {
	public PathUtils() {
	}

	public static String getResourceFromMap(String mapSetID, String resourceName) {
		return Objects.requireNonNull(
				PathUtils.class
						.getClassLoader()
						.getResource("maps/" + mapSetID + "/" + resourceName))
				.getPath();
	}
}
