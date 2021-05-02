package handlers;

import core.Config;
import greenfoot.World;

/**
 * This class handles all the UI objects ( Actors ) of a selected world
 */
public class UIHandler implements Handler {
	private final World world;
	private final Config config = Config.getInstance();
	
	public UIHandler(World world) {
		this.world = world;
	}

	public void start() {
		
	}

	public void configure() {
		
	}

	public void close() {

	}
}
