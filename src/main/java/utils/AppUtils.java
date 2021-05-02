package utils;

import core.Config;

public class AppUtils {
	public static Config config = Config.getInstance();
	
	public AppUtils() {
	}

	/**
	 * Get the delta time between the current frame and the last frame
	 */
	public static double getFramesDeltaTime() {
		var currentTime = System.nanoTime();
		var deltaTime = (currentTime - config.getValue(Long.class, "APP_LAST_FRAME_TIME")) / 1000000.0;
		
		config.setValue("APP_LAST_FRAME_TIME", currentTime);

		return deltaTime;
	}
	
	public static void refreshLastFrameTime() {
		config.setValue("APP_LAST_FRAME_TIME", System.nanoTime());
	}
}
