package worlds;

import actors.Button;
import actors.ImageHolder;
import core.Config;
import graphics.ShapeDrawer;
import graphics.Text;
import greenfoot.Color;
import greenfoot.Font;
import greenfoot.GreenfootSound;
import greenfoot.World;
import models.Map;
import parsers.MapJsonParser;
import utils.PathUtils;
import utils.WorldUtils;

public class Menu extends World {
	// In a DI container I would be injecting this....
	private static final Config config = Config.getInstance();
	private static final Menu instance = new Menu();

	private final GreenfootSound bgMusic = new GreenfootSound("menu.wav");

	private Menu() {
		// bounded = false because I will hide actors offscreen
		super(
				config.getValue("APP_WIDTH"),
				config.getValue("APP_HEIGHT"),
				1,
				false
		);

		bgMusic.setVolume(50);
		bgMusic.playLoop();

		this.setBackground(WorldUtils.createWorldBackground(new Color(43, 43, 43)));
	}

	public static Menu getInstance() {
		return instance;
	}

	@Override
	public void started() {
		// Since this is the Menu World, I will create all menu actors ( not play area ones ) off screen
		// TODO - Create helper methods for the creation of buttons ( I will probably need padding, margin, and grids... )
		this.addObject(
				new ImageHolder(
						ShapeDrawer.Rectangle(
								400, 50, new Color(0, 0, 0, 0),
								new Text(
										"DRUMBEATS",
										new Font("Arial Rounded MT Bold", 72),
										Color.BLACK,
										Color.BLACK
								)
						)
				),
				this.getWidth() / 2,
				this.getHeight() / 4
		);

		// This is a test to have the bare minimum to enter the play area
		this.addObject(
				new Button(
						400, 60, Color.WHITE,
						new Text(
								"Play Field",
								new Font("Comic Sans MS Bold", 45),
								Color.BLACK,
								Color.BLACK
						),
						() -> {
							// Testing of course
							String mapFilePath = PathUtils.getResourceFromMap(
									"b82af975-4d44-4608-b686-70d61851508d",
									"7b9ac868-675d-4e53-bb84-2305290fbf63.map"
							);
							Map map = MapJsonParser.parse(mapFilePath);

							WorldUtils.setWorld(this, new PlayField(map));
						}
				),
				this.getWidth() / 2,
				this.getHeight() / 2
		);
	}

	@Override
	public void stopped() {
		bgMusic.stop();
	}
}
