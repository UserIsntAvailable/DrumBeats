package worlds;

import core.Config;
import greenfoot.World;
import handlers.MapHandler;
import handlers.PlayFieldUIHandler;
import models.Map;
import utils.AppUtils;
import utils.NoteUtils;

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

		mapHandler = new MapHandler(map);
		playFieldUIHandler = new PlayFieldUIHandler(this);

		mapHandler.start();
		playFieldUIHandler.start();

		AppUtils.refreshLastFrameTime();
		timeWhenStarted = System.currentTimeMillis();
	}

	@Override
	public void act() {
		AppUtils.refreshFramesDeltaTime();
		var notesQueue = mapHandler.getNoteQueue();
		if (notesQueue.size() > 0) {
			var note = notesQueue.peek();
			var noteModel = note.getNoteModel();
			if (noteModel.getTime() <= System.currentTimeMillis() - timeWhenStarted - NoteUtils.getNoteOffsetTime(noteModel)) {
				this.addObject(
						note,
						(int) (this.getWidth() + NoteUtils.getNoteDiameter(noteModel) / 2),
						config.getValue("ACTORS_Y_POSITION")
				);
				notesQueue.poll();
			}
		}
	}

	@Override
	public void stopped() {
		mapHandler.close();
		playFieldUIHandler.close();
	}
}
