package utils;

import core.Config;
import enums.DrumType;
import javafx.util.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class AppUtils {
	private static Config config = Config.getInstance();
	
	public AppUtils(Config config) {
		AppUtils.config = config;
	}
	
	public static List<String> getDrumKeys(DrumType drumType) {
		return ((List<Pair<DrumType,String>>)config.getValue("APP_DRUM_KEYS")).stream()
				.filter(drumKey -> drumKey.getKey().equals(drumType))
				.map(Pair::getValue)
				.collect(Collectors.toList());
	}

	public static void refreshFramesDeltaTime() {
		var currentTime = System.nanoTime();
		config.setValue("APP_FRAMES_DELTA_TIME", (currentTime - config.getValue(Long.class, "APP_LAST_FRAME_TIME")) / 1000000.0);
		config.setValue("APP_LAST_FRAME_TIME", currentTime);
	}
	
	public static void refreshLastFrameTime() {
		config.setValue("APP_LAST_FRAME_TIME", System.nanoTime());
	}
}
