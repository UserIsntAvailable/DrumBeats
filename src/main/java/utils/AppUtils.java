package utils;

import core.Config;

public class AppUtils {
	public static Config config = Config.getInstance();
	
	public AppUtils() {
	}

	/**
	 * Get the delta time between the current frame and the last frame
	 */
	public static void refreshFramesDeltaTime() {
		var currentTime = System.nanoTime();
		config.setValue("APP_FRAMES_DELTA_TIME", (currentTime - config.getValue(Long.class, "APP_LAST_FRAME_TIME")) / 1000000.0);
		config.setValue("APP_LAST_FRAME_TIME", currentTime);
	}
	
	public static void refreshLastFrameTime() {
		config.setValue("APP_LAST_FRAME_TIME", System.nanoTime());
	}
}
