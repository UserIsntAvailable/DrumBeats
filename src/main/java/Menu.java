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
		super.setBackground(PathUtils.getFilePathFromResourcesFolder("menu.png"));
	}
}
