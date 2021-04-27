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
		setUpImageCache();
	}

	private static void setUpImageCache() {
		ImageCache imageCache = ImageCache.getInstance();

		// Set up here the image cache here
	}
}
