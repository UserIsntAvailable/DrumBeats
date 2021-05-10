package events;

import actors.NoteActor;

public class NoteEvent {
	private final NoteActor note;
	private final long created;

	public NoteEvent(NoteActor note) {
		this.note = note;
		this.created = System.currentTimeMillis();
	}

	public NoteActor getNote() {
		return this.note;
	}

	public long getCreatedTime() {
		return this.created;
	}
}
