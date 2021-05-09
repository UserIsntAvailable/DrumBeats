package core;

import enums.DrumType;
import greenfoot.core.ImageCache;
import javafx.util.Pair;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Set up important things needed by the game like:
 * Config, Parsers, ImageCache and others
 */
public class Startup {
	public Startup() {
	}

	public static void setUpApplication() {
		setUpConfig();
		setUpImageCache();
	}

	private static void setUpImageCache() {
		var imageCache = ImageCache.getInstance();

		// Set up here the image cache here
	}

	private static void setUpConfig() {
		var config = Config.getInstance();

		config.setValue("APP_WIDTH", 1280);
		config.setValue("APP_HEIGHT", 720);
		config.setValue("APP_DRUM_KEYS",
				List.of(
						new Pair<>(DrumType.OUTER, "d"),
						new Pair<>(DrumType.INNER, "f"),
						new Pair<>(DrumType.INNER, "j"),
						new Pair<>(DrumType.OUTER, "k")
				)
		);
		// This means when the last frame was called
		config.setValue("APP_LAST_FRAME_TIME", System.nanoTime());
	}
}
