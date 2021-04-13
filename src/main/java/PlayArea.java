import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import utils.PathUtils;

public class PlayArea extends World {
	public PlayArea() {
		super(1280, 720, 1);
	}

	@Override
	public void started() {
		super.setBackground(PathUtils.getFilePathFromResourcesFolder("play_area_default.png"));
	}
}
