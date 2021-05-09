package worlds;

import core.Config;
import greenfoot.Color;
import greenfoot.World;
import handlers.MapHandler;
import handlers.PlayFieldUIHandler;
import models.Map;
import utils.AppUtils;
import utils.NoteUtils;
import utils.WorldUtils;

/**
 * Basically where the gameplay takes place.
 */
public class PlayField extends World {
	private final long timeWhenStarted;
	private final MapHandler mapHandler;
	private final PlayFieldUIHandler playFieldUIHandler;
	private static final Config config = Config.getInstance();

	public PlayField(Map map) {
		super(
				config.getValue("APP_WIDTH"),
				config.getValue("APP_HEIGHT"),
				1,
				false
		);

		this.setBackground(WorldUtils.createWorldBackground(Color.BLACK));

		mapHandler = new MapHandler(map);
		playFieldUIHandler = new PlayFieldUIHandler(this);

		this.started();

		timeWhenStarted = System.currentTimeMillis();
	}

	@Override
	public void act() {
		AppUtils.refreshFramesDeltaTime();
		var note = mapHandler.peekNextNote();
		if (note != null) {
			var noteModel = note.getNoteModel();
			if (noteModel.getTime() <= System.currentTimeMillis() - timeWhenStarted - NoteUtils.getNoteOffsetTime(noteModel)) {
				this.addObject(
						note,
						(int) (this.getWidth() + NoteUtils.getNoteDiameter(noteModel) / 2),
						config.getValue("ACTORS_Y_POSITION")
				);
				mapHandler.removeNextNote();
			}
		}
	}

	@Override
	public void started() {
		mapHandler.start();
		playFieldUIHandler.start();
		AppUtils.refreshLastFrameTime();
	}

	@Override
	public void stopped() {
		mapHandler.close();
		playFieldUIHandler.close();
	}
}
