package core.worlds;

import core.utils.Constants;
import core.utils.Startup;
import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * a.k.a SplashScreen
 */
public class Intro extends World {
//	private final GifImage gifImage;
	
	public Intro() {
		super(Constants.APP_WIDTH, Constants.APP_HEIGHT, 1);

		Startup.setUpApplication();

		// TODO - Create GIF animation
		// TODO - Add "SplashScreen" animation ( I will use a GifImage )
		
		// This is just for testing...
		// FUCK GREENFOOT, IT CAN SUCK MY DICK WITH ITS STUPID ERRORS
//		gifImage = new GifImage("pretty-gif.gif");
	}

	@Override
	public void act() {
		if (Greenfoot.isKeyDown("space")) {
			Greenfoot.setWorld(Menu.getInstance());
		}
	}
}
