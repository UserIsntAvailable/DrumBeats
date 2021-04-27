package worlds;

import actors.Button;
import core.Config;
import utils.WorldUtils;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.Greenfoot;
import greenfoot.World;

public class Menu extends World {
	private static final Menu instance = new Menu();

	private Menu() {
		// bounded = false because I will hide actors offscreen
		super(Config.APP_WIDTH, Config.APP_HEIGHT, 1, false);

		super.setBackground(WorldUtils.createWorldBackground(new Color(43, 43, 43)));

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
				Config.APP_WIDTH / 2,
				Config.APP_HEIGHT / 2
		);
	}

	public static Menu getInstance() {
		return instance;
	}
}
