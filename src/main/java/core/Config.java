package core;

import java.util.HashMap;

public class Config {
	//region Private Fields
	private static final Config instance = new Config();

	private final HashMap<String, Object> configValues = new HashMap<>();
	//endregion

	//region Constructor
	private Config() {
	}
	//endregion

	//region Public Methods
	public static Config getInstance() {
		return instance;
	}

	public <T> T getValue(Class<T> clazz, String key) {
		var configValue = configValues.get(key);
		
		return clazz.isInstance(configValue) 
				? clazz.cast(configValue) 
				: null;
	}

	public void setValue(String key, Object value) {
		configValues.put(key, value);
	}
	//endregion
}
