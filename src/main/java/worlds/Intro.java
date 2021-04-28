package worlds;

import actors.ImageHolder;
import core.Config;
import core.Startup;
import greenfoot.Greenfoot;
import greenfoot.World;
import utils.GifImage;

/**
 * a.k.a SplashScreen. This is the "entry point" if the game is run from Greenfoot.
 */
public class Intro extends World {
	private final GifImage gifImage;
	// I need this because World.setBackground duplicates the image until it fits the world dimensions
	private final ImageHolder gifImageHolder;

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
		gifImage = new GifImage("pretty-gif.gif");
		gifImageHolder = new ImageHolder(gifImage.getCurrentImage());
		this.addObject(
				gifImageHolder,
				this.getWidth() / 2,
				this.getHeight() / 2
		);
	}

	@Override
	public void act() {
		gifImageHolder.setImage(gifImage.getCurrentImage());
		if (Greenfoot.isKeyDown("space")) {
			Greenfoot.setWorld(Menu.getInstance());
		}
	}
}
