package utils;

import core.Config;

public class AppUtils {
	public AppUtils() {
	}

	/**
	 * Get the delta time between the current frame and the last frame
	 */
	public static double getFramesDeltaTime(Config config) {
		var currentTime = System.nanoTime();
		var deltaTime = (currentTime - config.getValue(Long.class, "APP_LAST_FRAME_TIME")) / 1000000.0;
		
		config.setValue("APP_LAST_FRAME_TIME", currentTime);

		return deltaTime;
	}
}
