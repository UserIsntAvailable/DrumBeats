import core.graphics.Drawable;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import utils.Constants;

public class PlayArea extends World {
	public PlayArea() {
		super(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, 1);
		super.setBackground(
				Drawable.DrawRectangle(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, Color.BLACK, "", null, null)
		);
	}
}
