package IO;

import core.Config;
import greenfoot.Greenfoot;

import java.util.HashMap;

// Special thanks to Nenikitov ( one of my friends )
public class KeyboardManager {
	private static Config config = Config.getInstance();

	private static final HashMap<String, Double> keysClickedTime = new HashMap<>();
	private static final HashMap<String, Boolean> wereKeysReleased = new HashMap<>();

	public KeyboardManager(Config config) {
		KeyboardManager.config = config;
	}

	public static boolean isKeyDown(String key) {
		return isKeyDown(key, config.getValue(Double.class, "APP_FRAMES_DELTA_TIME")  * 2.1);
	}

	public static boolean isKeyDown(String key, double pressTime) {
		if (!keysClickedTime.containsKey(key)) {
			keysClickedTime.put(key, 0.0);
			wereKeysReleased.put(key, false);
		}

		boolean keyPressed = Greenfoot.isKeyDown(key);

		if (keyPressed) {
			if (wereKeysReleased.get(key)) {
				keysClickedTime.put(key, pressTime);
				wereKeysReleased.put(key, false);
			}
		}
		else
			wereKeysReleased.put(key, true);

		if (keysClickedTime.get(key) > 0)
			keysClickedTime.put(key, keysClickedTime.get(key) - config.getValue(Double.class, "APP_FRAMES_DELTA_TIME"));

		return keysClickedTime.get(key) > 0;
	}
}
