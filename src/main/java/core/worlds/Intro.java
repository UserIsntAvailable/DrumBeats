package core.worlds;

import core.utils.Constants;
import core.utils.GifImage;
import core.utils.PathUtils;
import greenfoot.Greenfoot;
import greenfoot.World;

/**
 * a.k.a SplashScreen
 */
public class Intro extends World {
	private final GifImage gifImage;
	
	public Intro() {
		super(Constants.APP_WIDTH, Constants.APP_HEIGHT, 1);

		// TODO - Create GIF animation
		// TODO - Add "SplashScreen" animation ( I will use a GifImage )
		
		// This is just for testing...
		gifImage = new GifImage(PathUtils.getFilePathFromResourcesFolder(Constants.MAIN_RESOURCES_PATH, "pretty-gif.gif"));
	}

	@Override
	public void act() {
		if (gifImage.isRunning()) {
		}
		
		if (Greenfoot.isKeyDown("space")) {
			Greenfoot.setWorld(Menu.getInstance());
		}
	}
}
