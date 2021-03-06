package models;

import enums.NoteType;
import enums.TaikoNote;

import java.util.EnumSet;
import java.util.Objects;

public class NoteModel {
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
	private final EnumSet<NoteType> noteType;

	/**
	 * Comma separated extra parameters that will change depending on the note {@link TaikoNote}
	 */
	private final String params;
	//endregion

	//region Constructor
	public NoteModel(int time, TaikoNote taikoNote, EnumSet<NoteType> noteType, String params) {
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

	public EnumSet<NoteType> getNoteType() {
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
		NoteModel noteModel = (NoteModel) o;
		return time == noteModel.time
				&& taikoNote == noteModel.taikoNote
				&& noteType.equals(noteModel.noteType)
				&& params.equals(noteModel.params);
	}

	@Override
	public int hashCode() {
		return Objects.hash(time, taikoNote, noteType, params);
	}
	//endregion
}
