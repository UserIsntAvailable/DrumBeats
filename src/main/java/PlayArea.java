import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import utils.Constants;

public class PlayArea extends World {
	public PlayArea() {
		super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1);
	}

	@Override
	public void started() {
		super.setBackground(
				new GreenfootImage("",
						0,
						null,
						Color.BLACK));
	}
}
