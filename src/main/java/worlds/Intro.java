package worlds;

import actors.ImageHolder;
import core.Config;
import core.Startup;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
import utils.GifImage;

/**
 * a.k.a SplashScreen. This is the "entry point" if the game is run from Greenfoot.
 */
public class Intro extends World {
	private final GifImage gifImage;
	private final GreenfootImage firstFrame;
	private final ImageHolder gifImageHolder;

	static {
		Startup.setUpApplication();
	}

	private static final Config config = Config.getInstance();

	public Intro() {
		super(
				config.getValue("APP_WIDTH"),
				config.getValue("APP_HEIGHT"),
				1
		);
		gifImage = new GifImage("splash-screen.gif");
		firstFrame = gifImage.getCurrentImage();
		gifImageHolder = new ImageHolder(firstFrame);
		this.addObject(
				gifImageHolder,
				this.getWidth() / 2,
				this.getHeight() / 2
		);
	}

	@Override
	public void act() {
		var gifFrame = gifImage.getCurrentImage();
		if (gifFrame.equals(firstFrame) ||
				Greenfoot.isKeyDown("space") ||
				Greenfoot.mouseClicked(null)) {

			Greenfoot.setWorld(Menu.getInstance());
			return;
		}
		gifImageHolder.setImage(gifFrame);
	}
}
