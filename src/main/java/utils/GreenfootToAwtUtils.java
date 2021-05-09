package utils;

import java.awt.*;

/**
 * I don't why I do this. I guess I should "force" myself to use Greenfoot framework....
 */
public class GreenfootToAwtUtils {

	public static java.awt.Font mapFont(greenfoot.Font font) {
		int style = 0;
		if (font.isBold()) {
			style = 1;
		}
		if (font.isItalic()) {
			style |= 2;
		}

		return new Font(font.getName(), style, font.getSize());
	}

	public static java.awt.Color mapColor(greenfoot.Color color) {
		return new java.awt.Color(
				color.getRed(),
				color.getGreen(),
				color.getBlue(),
				color.getAlpha()
		);
	}
}
