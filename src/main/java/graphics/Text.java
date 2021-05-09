package graphics;

import utils.GreenfootToAwt;

/**
 * A class representing text. ( I use this because I'm tired of having so much parameters on {@link ShapeDrawer} methods ).
 */
public class Text {
	//region Private Fields
	private final String text;
	private final java.awt.Font font;
	private final java.awt.Color textColor;
	private final java.awt.Color outlineColor;
	//endregion

	//region Constructor
	public Text(String text, greenfoot.Font font, greenfoot.Color textColor, greenfoot.Color outlineColor) {
		this.text = text;
		this.font = GreenfootToAwt.mapFont(font);
		this.textColor = GreenfootToAwt.mapColor(textColor);
		this.outlineColor = GreenfootToAwt.mapColor(outlineColor);
	}
	//endregion

	//region Getters
	public String getText() {
		return text;
	}

	public java.awt.Font getFont() {
		return font;
	}

	public java.awt.Color getTextColor() {
		return textColor;
	}

	public java.awt.Color getOutlineColor() {
		return outlineColor;
	}
	//endregion

	//region Public Methods
	public static Text getDefault() {
		return new Text(
				"",
				new greenfoot.Font(14),
				greenfoot.Color.WHITE,
				greenfoot.Color.BLACK
		);
	}
	//endregion
}
