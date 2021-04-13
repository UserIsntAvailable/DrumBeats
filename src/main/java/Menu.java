import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import utils.PathUtils;

public class Menu extends World {
	public Menu() {
		// bounded = false because I will hide actors offscreen
		super(1280, 720, 1, false);
	}

	@Override
	public void started() {
		super.setBackground(PathUtils.getFilePathFromResourcesFolder("menu.png"));
	}
}
