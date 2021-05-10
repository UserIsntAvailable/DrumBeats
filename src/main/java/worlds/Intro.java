package worlds;

import actors.ImageHolder;
import core.Config;
import core.Startup;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
import utils.GifImage;

import java.util.List;

/**
 * a.k.a SplashScreen. This is the entry point of the game.
 */
public class Intro extends World {
	//region Static Block	
	static {
		Startup.setUpApplication();
	}
	//endregion

	//region Private Fields
	private int currentFrame = 0;
	private final ImageHolder gifImageHolder;
	private final List<GreenfootImage> gifImages;

	private static final Config config = Config.getInstance();
	//endregion
	
	//region Constructor
	public Intro() {
		super(
				config.getValue("APP_WIDTH"),
				config.getValue("APP_HEIGHT"),
				1
		);
		
		var gifImage = new GifImage("splash-screen.gif");
		gifImages = gifImage.getImages();
		gifImageHolder = new ImageHolder(gifImage.getCurrentImage());
		this.addObject(
				gifImageHolder,
				this.getWidth() / 2,
				this.getHeight() / 2
		);
	}
	//endregion

	//region Public Methods
	@Override
	public void act() {
		if (currentFrame >= gifImages.size() || Greenfoot.isKeyDown("space") || Greenfoot.mouseClicked(null)) {
			Greenfoot.setWorld(Menu.getInstance());
			return;
		}
		gifImageHolder.setImage(gifImages.get(currentFrame));
		currentFrame++;
	}
	//endregion
}
