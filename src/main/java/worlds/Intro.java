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
	
	public Intro() {
		super(Config.APP_WIDTH, Config.APP_HEIGHT, 1);

		Startup.setUpApplication();

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
