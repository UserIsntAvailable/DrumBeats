package worlds;

import core.Config;
import core.Startup;
import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * a.k.a SplashScreen
 */
public class Intro extends World {
	//	private final GifImage gifImage;
	static {
		Startup.setUpApplication();
	}

	private static final Config config = Config.getInstance();

	public Intro() {
		super(
				config.getValue(Integer.class, "APP_WIDTH"),
				config.getValue(Integer.class, "APP_HEIGHT"),
				1
		);

		// TODO - Create GIF animation
		// TODO - Add "SplashScreen" animation ( I will use a GifImage )
		
		// This is just for testing...
		// Having errors with this...
//		gifImage = new GifImage("pretty-gif.gif");
	}

	@Override
	public void act() {
		if (Greenfoot.isKeyDown("space")) {
			Greenfoot.setWorld(Menu.getInstance());
		}
	}
}
