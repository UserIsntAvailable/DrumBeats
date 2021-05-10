package events;

import actors.NoteActor;

public class NoteEvent {
	//region Private Fields
	private final NoteActor note;
	private final long created;
	private final int keyState;
	//endregion
	
	//region Constructor 
	public NoteEvent(NoteActor note, int keyState) {
		this.note = note;
		this.keyState = keyState;
		this.created = System.currentTimeMillis();
	}
	//endregion
	
	//region Getters
	public NoteActor getNote() {
		return this.note;
	}

	public long getCreatedTime() {
		return this.created;
	}
	
	public int getKeyState() {return this.keyState;}
	//endregion
}
