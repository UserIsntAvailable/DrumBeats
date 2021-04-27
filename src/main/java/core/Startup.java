package core;

import greenfoot.core.ImageCache;

/**
 * Set up important settings needed by the project like:
 * Config, Parsers, ImageCache and others
 */
public class Startup {
	public Startup() {
	}
	
	public static void setUpApplication(){
		setUpConfig();
		setUpImageCache();
	}

	private static void setUpImageCache() {
		ImageCache imageCache = ImageCache.getInstance();

		// Set up here the image cache here
	}
	
	private static void setUpConfig() {
		var config = Config.getInstance();
		
		config.setValue("APP_WIDTH", 1280);
		config.setValue("APP_HEIGHT", 720);
	}
}
