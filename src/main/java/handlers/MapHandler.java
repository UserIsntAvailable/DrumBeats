package handlers;

import actors.NoteActor;
import core.Config;
import models.Map;
import utils.NotesListUtils;

import java.util.Queue;

/**
 * Class handles every aspect of a map object
 */
public class MapHandler implements Handler {
	//region Private Fields
	private final Map map;
	private final Config config = Config.getInstance();

	private Queue<NoteActor> notesQueue;
	//endregion

	//region Constructor
	public MapHandler(Map map) {
		this.map = map;
		configure();
		//TODO - Create a BGSoundHandler?
	}
	//endregion

	//region Handler
	public long start() {
		setNoteQueue();

		return System.nanoTime();
	}

	public void configure() {
		config.setValue("NOTES_DIAMETER", config.getValue(Integer.class, "APP_WIDTH") / 20);
		config.setValue("NOTES_MOVEMENT_SPEED", config.getValue(Integer.class, "APP_WIDTH") / -5120.0);
		config.setValue("BIG_NOTES_MULTIPLIER", config.getValue(Integer.class, "APP_HEIGHT") / 850.0);
	}

	public void close() {
	}
	//endregion

	//region Public Methods
	public Queue<NoteActor> getNoteQueue() {
		return notesQueue;
	}
	//endregion

	//region Private Methods
	private void setNoteQueue() {
		notesQueue = (Queue<NoteActor>) NotesListUtils.mapToNoteActor(map.getNotes());
	}
	//endregion
}
