import core.graphics.Drawable;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import utils.Constants;
import utils.PathUtils;

public class Menu extends World {
	public Menu() {
		// bounded = false because I will hide actors offscreen
		super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1, false);
	}

	@Override
	public void started() {
		super.setBackground(PathUtils.getFilePathFromResourcesFolder(Constants.MAIN_RESOURCES_PATH,"menu.png"));
		prepareWorld();
	}

	private void prepareWorld() {
		// Since this is the Menu World, I will create all menu actors ( not play area ones ) off screen
		// TODO - Create helper methods for the creation of buttons ( I will probably need padding, margin, and grids... )

		// This is a test to have the bare minimum to enter the play area
		addObject(
				new Button(
						400, 60, Color.WHITE,
						"", new Font(69), Color.RED,
						(Greenfoot::setWorld)
				),
				Constants.SCREEN_WIDTH / 2,
				Constants.SCREEN_HEIGHT / 2
		);
	}
}
