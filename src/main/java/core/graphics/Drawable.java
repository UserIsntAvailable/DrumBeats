package core.graphics;

import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootImage;

public class Drawable {
	public static GreenfootImage DrawRectangle(int width, int height, Color background,
	                                           String text, Font font, Color textColor) {
		
		// TODO - Have rounded rectangles
		// TODO - Outline for the rectangle

		GreenfootImage baseImage = new GreenfootImage(width,height);
		baseImage.setColor(background);
		baseImage.fill();
		baseImage.setColor(textColor == null ? Color.BLACK : textColor);
		baseImage.setFont(font == null ? new Font(0) : font);
		// BUG - This doesn't really place the string in the half of the button....
		baseImage.drawString(text, width / 2, height / 2);

		return baseImage;
	}
}
