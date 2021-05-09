package graphics;

import greenfoot.Color;
import greenfoot.GreenfootImage;
import greenfoot.util.GraphicsUtilities;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

// TODO - Outline for images
public class ShapeDrawer {
	public static GreenfootImage Rectangle(int width, int height, Color background, Text text) {
		// TODO - Have rounded rectangles
		GreenfootImage baseImage = new GreenfootImage(width, height);
		baseImage.setColor(background);
		baseImage.fill();
		SetTextOnImage(text, baseImage, width / 2, height / 2);

		return baseImage;
	}

	public static GreenfootImage RectangleWithoutText(int width, int height, Color background) {
		return Rectangle(width, height, background, Text.getDefault());
	}

	public static GreenfootImage Circle(int diameter, Color background, Text text) {
		GreenfootImage baseImage = new GreenfootImage(diameter, diameter);

		baseImage.setColor(background);
		baseImage.fillOval(0, 0, diameter, diameter);
		SetTextOnImage(text, baseImage, diameter / 2, diameter / 2);

		return baseImage;
	}

	public static GreenfootImage CircleWithoutText(int diameter, Color background) {
		return Circle(diameter, background, Text.getDefault());
	}

	private static void SetTextOnImage(Text text, GreenfootImage image, int x, int y) {

		var lines = GraphicsUtilities.splitLines(text.getText());
		var dimensions = getMultiLineStringDimensions(lines, text.getFont());
		// I will not bother passing this as a parameter
		var cellSize = 1;
		int yDraw = y * cellSize - dimensions.getHeight() / 2 + cellSize / 2;
		int xDraw = x * cellSize - dimensions.getWidth() / 2 + cellSize / 2;

		var g = image.getAwtImage().createGraphics();

		g.translate(xDraw, yDraw);
		drawOutlinedText(g, dimensions, text.getTextColor(), text.getOutlineColor());
		g.translate(-xDraw, -yDraw);
	}

	//region Awt stuff ( Authors: Greenfoot developers, I needed to change some things though )
	public static void drawOutlinedText(Graphics2D g, MultiLineStringDimensions d, java.awt.Color foreground, java.awt.Color outline) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		for (int i = 0; i < d.lineShapes.length; i++) {
			g.setColor(foreground);
			g.fill(d.lineShapes[i]);
			if (outline != null) {
				g.setColor(outline);
				g.draw(d.lineShapes[i]);
			}

		}
	}

	public static MultiLineStringDimensions getMultiLineStringDimensions(String[] lines, java.awt.Font font) {
		BufferedImage image = GraphicsUtilities.createCompatibleTranslucentImage(1, 1);
		MultiLineStringDimensions r = new MultiLineStringDimensions(lines.length);
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		setFontOfPixelHeight(g, font);

		FontRenderContext frc = g.getFontRenderContext();
		Rectangle2D[] lineBounds = new Rectangle2D[lines.length];
		int maxX = 1;
		int y = 0;
		for (int i = 0; i < lines.length; i++) {
			lineBounds[i] = g.getFontMetrics().getStringBounds(lines[i], g);
			maxX = Math.max(maxX, (int) Math.ceil(lineBounds[i].getWidth()));
			y += Math.ceil(lineBounds[i].getHeight());
		}
		y = Math.max(y + 1, 1);
		r.overallBounds = new Dimension(maxX, y);

		y = 0;
		for (int i = 0; i < lines.length; i++) {
			// Draw the shape in the right space in the overall text, by translating it down and moving to middle:
			AffineTransform translate = AffineTransform.getTranslateInstance((r.overallBounds.getWidth() - lineBounds[i].getWidth()) / 2, y - lineBounds[i].getMinY() /* add on to baseline */);
			r.lineShapes[i] = new TextLayout(!lines[i].isEmpty() ? lines[i] : " ", g.getFont(), frc).getOutline(translate);
			y += Math.ceil(lineBounds[i].getHeight());
		}
		// Make it at least one pixel, and add one for the outline width:

		g.dispose();

		return r;
	}

	private static void setFontOfPixelHeight(Graphics2D g, java.awt.Font font) {
		// Likely DPI ranges for a monitor: 120 to 500 pixels per inch (via wikipedia)
		// An inch is 72 points, so range is something like 1 pixel per point to 8 pixels per point
		// So we explore from 1 point, up to the desired pixel size in points.
		// e.g. if we want 40 pixels, then a 40 point font is going to be bigger than 40 pixels if the display is above 72 DPI
		var targetSize = font.getSize();
		font = new java.awt.Font(font.getName(), font.getStyle(), 1);

		for (int i = 1; i < targetSize; i++) {
			java.awt.Font bigger = font.deriveFont((float) i);
			g.setFont(bigger);
			// This string should be full height in the font:
			if (bigger.getLineMetrics("WBLMNqpyg", g.getFontRenderContext()).getHeight() < targetSize) // getStringHeight(g, "WBLMNqpyg") < targetSize)
			{
				font = bigger;
			}
			else {
				break; // Too big; keep previous
			}
		}
		g.setFont(font);
	}

	public static class MultiLineStringDimensions {
		private final Shape[] lineShapes;
		private Dimension overallBounds;

		public MultiLineStringDimensions(int length) {
			lineShapes = new Shape[length];
		}

		public int getWidth() {
			return overallBounds.width;
		}

		public int getHeight() {
			return overallBounds.height;
		}
	}
	//endregion
}
