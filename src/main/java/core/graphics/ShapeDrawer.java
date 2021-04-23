package core.graphics;

import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootImage;

// TODO - Outline for images
public class ShapeDrawer {
	public static GreenfootImage Rectangle(int width, int height, Color background,
	                                       String text, Font font, Color textColor) {
		// TODO - Have rounded rectangles
		GreenfootImage baseImage = new GreenfootImage(width, height);
		baseImage.setColor(background);
		baseImage.fill();
		SetTextOnImage(baseImage, width / 2, height / 2, text, font, textColor);

		return baseImage;
	}

	public static GreenfootImage RectangleWithoutText(int width, int height, Color background) {
		return Rectangle(width, height, background, "", null, null);
	}

	public static GreenfootImage Circle(int diameter, Color background,
	                                    String text, Font font, Color textColor) {
		GreenfootImage baseImage = new GreenfootImage(diameter, diameter);

		baseImage.setColor(background);
		baseImage.fillOval(0, 0, diameter, diameter);
		SetTextOnImage(baseImage, diameter / 2, diameter / 2, text, font, textColor);

		return baseImage;
	}

	public static GreenfootImage CircleWithoutText(int diameter, Color background) {
		return Circle(diameter, background, "", null, null);
	}

	// BUG - drawString doesn't really put the string in the middle of the image
	private static void SetTextOnImage(GreenfootImage image, int x, int y,
	                                   String text, Font font, Color textColor) {
		image.setColor(textColor == null ? Color.BLACK : textColor);
		image.setFont(font == null ? new Font(0) : font);
		image.drawString(text, x, y);
	}
}
