package actors;

import graphics.ShapeDrawer;
import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

/**
 * A Counter class that allows you to display a numerical value on screen.
 * <p>
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.  Here's an example of a world class that
 * displays a counter with the number of act cycles that have occurred:
 *
 * <pre>
 * class CountingWorld
 * {
 *     private Counter actCounter;
 *
 *     public CountingWorld()
 *     {
 *         super(600, 400, 1);
 *         actCounter = new Counter("Act Cycles: ");
 *         addObject(actCounter, 100, 100);
 *     }
 *
 *     public void act()
 *     {
 *         actCounter.setValue(actCounter.getValue() + 1);
 *     }
 * }
 * </pre>
 *
 * @author Neil Brown and Michael Kölling
 * @version 1.0
 */
public class Counter extends Actor {
    //region Private Fields
	private static final Color transparent = new Color(0, 0, 0, 0);
	private int height;
	private int value;
	private int target;
	private String prefix;
	//endregion
    
    //region Constructors
	public Counter(int height) {
		this("", height);
	}

	/**
	 * Create a new counter, initialised to 0.
	 */
	public Counter(String prefix, int height) {
		this.height = height;
		this.value = 0;
		this.target = 0;
		this.prefix = prefix;
		updateImage();
	}
	//endregion
    
    //region Public Methods
	/**
	 * Animate the display to count up (or down) to the current target value.
	 */
	@Override
	public void act() {
		if (value < target) {
			value++;
			updateImage();
		}
		else if (value > target) {
			value--;
			updateImage();
		}
	}
    
	/**
	 * Add a new score to the current counter value.  This will animate
	 * the counter over consecutive frames until it reaches the new value.
	 */
	public void add(int score) {
		target += score;
	}

	/**
	 * Return the current counter value.
	 */
	public int getValue() {
		return target;
	}

	/**
	 * Set a new counter value.  This will not animate the counter.
	 */
	public void setValue(int newValue) {
		target = newValue;
		value = newValue;
		updateImage();
	}

	/**
	 * Sets a text prefix that should be displayed before
	 * the counter value (e.g. "Score: ").
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
		updateImage();
	}
	//endregion
    
	//region Private Methods
	/**
	 * Update the image on screen to show the current value.
	 */
	private void updateImage() {
		GreenfootImage image = ShapeDrawer.RectangleWithoutText(1,height, transparent);
		GreenfootImage text = new GreenfootImage(prefix + value, height, Color.WHITE, transparent);

		if (text.getWidth() > image.getWidth() - 20) {
			image.scale(text.getWidth() + 20, image.getHeight());
		}

		image.drawImage(text, (image.getWidth() - text.getWidth()) / 2,
				(image.getHeight() - text.getHeight()) / 2);
		setImage(image);
	}
	//endregion
}
