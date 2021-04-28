package worlds;

import actors.Button;
import core.Config;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.Greenfoot;
import greenfoot.World;
import utils.WorldUtils;

public class Menu extends World {
	// In a DI container I would be injecting this....
	/* NOTE: If I put this under the instance the config would have not been created and I would get null exception.
	         Really interesting thing tbh... */
	private static final Config config = Config.getInstance();
	
	private static final Menu instance = new Menu();;

	private Menu() {
		// bounded = false because I will hide actors offscreen
		super(
				config.getValue(Integer.class, "APP_WIDTH"),
				config.getValue(Integer.class, "APP_HEIGHT"),
				1,
				false
		);

		this.setBackground(WorldUtils.createWorldBackground(new Color(43, 43, 43)));

		prepareWorld();
	}

	private void prepareWorld() {
		// Since this is the Menu World, I will create all menu actors ( not play area ones ) off screen
		// TODO - Create helper methods for the creation of buttons ( I will probably need padding, margin, and grids... )

		// This is a test to have the bare minimum to enter the play area
		addObject(
				new Button(
						400, 60, Color.WHITE,
						"", new Font(69), Color.RED,
						(Greenfoot::setWorld)
				),
				this.getWidth() / 2,
				this.getHeight() / 2
		);
	}
	
	public static Menu getInstance() {
		return instance;
	}
}
