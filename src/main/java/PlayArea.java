import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import utils.Constants;
import utils.PathUtils;

public class PlayArea extends World {
	public PlayArea() {
		super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1);
	}

	@Override
	public void started() {
		super.setBackground(PathUtils.getFilePathFromResourcesFolder("play_area_default.png"));
	}
}
