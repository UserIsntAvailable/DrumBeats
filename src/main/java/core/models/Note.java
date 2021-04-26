package core.models;

import core.enums.NoteType;
import core.enums.TaikoNote;

import java.util.Objects;

public class Note {
	//region Private Fields

	/**
	 * Time when the object is to be hit, in milliseconds from the beginning of the map audio.
	 */
	private final int time;

	/**
	 * Taiko note type, see:{@link TaikoNote}
	 */
	private final TaikoNote taikoNote;

	/**
	 * Note type, see:{@link NoteType}
	 */
	private final NoteType noteType;

	/**
	 * Comma separated extra parameters that will change depending on the note {@link TaikoNote}
	 */
	private final String params;
	//endregion

	//region Constructor
	public Note(int time, TaikoNote taikoNote, NoteType noteType, String params) {
		this.time = time;
		this.taikoNote = taikoNote;
		this.noteType = noteType;
		this.params = params;
	}
	//endregion

	//region Getters
	public int getTime() {
		return time;
	}

	public TaikoNote getTaikoNote() {
		return taikoNote;
	}

	public NoteType getNoteType() {
		return noteType;
	}

	public String getParams() {
		return params;
	}
	//endregion

	//region Public Methods
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Note note = (Note) o;
		return time == note.time
				&& taikoNote == note.taikoNote
				&& noteType == note.noteType
				&& params.equals(note.params);
	}

	@Override
	public int hashCode() {
		return Objects.hash(time, taikoNote, noteType, params);
	}
	//endregion
}
