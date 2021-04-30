package utils;

import java.util.Objects;

public class PathUtils {
	public PathUtils() {
	}

	public static String getMapFromResources(String mapSetID, String mapID) {
		return Objects.requireNonNull(
				PathUtils.class
						.getClassLoader()
						.getResource("maps" + mapSetID + "/" + mapID))
				.getPath();
	}
}
