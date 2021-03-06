package handlers;

import actors.NoteCatcher;
import core.Config;
import events.NoteCatcherListener;
import events.NoteEvent;
import greenfoot.core.WorldHandler;
import utils.NoteUtils;
import utils.SoundUtils;

public class NoteHandler implements Handler {
	//region Private Fields	
	private final Config config = Config.getInstance();
	//endregion
	
	//region Constructor
	public NoteHandler() {
		configure();
	}
	//endregion

	//region Handler
	@Override
	public long start() {
		var currentWorld = WorldHandler.getInstance().getWorld();

		var noteCatcher = currentWorld.getObjects(NoteCatcher.class).get(0);

		noteCatcher.addNoteCatcherListener(new NoteCatcherListener() {
			@Override
			public void noteClicked(NoteEvent note) {
				var actor = note.getNote();
				currentWorld.removeObject(actor);
				if (NoteUtils.isBigNote(actor.getNoteModel())) {
					SoundUtils.playSound(
							"drum-big-notes-hitsound.wav",
							config.getValue(Integer.class, "HITSOUNDS_BASE_VOLUME") + 10
					);
				}
			}

			@Override
			public void noteMissed(NoteEvent note) {
				var actor = note.getNote();
				currentWorld.removeObject(actor);
				SoundUtils.playMissSound();
			}
		});
		
		return System.currentTimeMillis();
	}

	@Override
	public void configure() {
		config.setValue("BIG_NOTES_MULTIPLIER", config.getValue(Integer.class, "APP_WIDTH") / 1000.0);
		config.setValue("NOTES_MOVEMENT_SPEED", config.getValue(Integer.class, "APP_WIDTH") / -5120.0);
	}

	@Override
	public void close() {
	}
	//endregion
}
