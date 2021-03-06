package handlers;

import actors.NoteActor;
import core.Config;
import models.Map;
import utils.ListUtils;
import utils.PathUtils;

import java.util.Queue;

/**
 * Class handles every aspect of a map object
 */
public class MapHandler implements Handler {
	//region Private Fields
	private final Map map;
	private final AudioHandler audioHandler;
	private final Config config = Config.getInstance();

	private Queue<NoteActor> mapNotesQueue;
	//endregion

	//region Constructor
	public MapHandler(Map map) {
		this.map = map;
		this.audioHandler = new AudioHandler(
				PathUtils.getResourceFromMap(
						map.getSetID(),
						map.getSongFilename()
				)
		);
		configure();
	}
	//endregion

	//region Handler
	public long start() {
		setMapNotesQueue();
		return audioHandler.start();
	}

	public void configure() {
		config.setValue("HITSOUNDS_BASE_VOLUME", 70);
	}

	public void close() {
		audioHandler.close();
	}
	//endregion

	//region Public Methods
	public NoteActor peekNextNote() {
		return mapNotesQueue.size() > 0 
				? mapNotesQueue.peek() 
				: null;
	}

	public void removeNextNote() {
		mapNotesQueue.poll();
	}
	//endregion

	//region Private Methods
	private void setMapNotesQueue() {
		mapNotesQueue = (Queue<NoteActor>) ListUtils.mapToNoteActor(map.getNotes());
	}
	//endregion
}
