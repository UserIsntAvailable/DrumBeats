package actors;

import enums.NoteType;
import graphics.ShapeDrawer;
import greenfoot.Color;
import models.NoteModel;

public class NoteActor extends SmoothMover {
	private final NoteModel noteModel;
	
	public NoteActor(int diameter, NoteModel noteModel) {
		this.noteModel = noteModel;
		
		// TODO - Set a different image depending in the taikoNote
		// TODO - Refactor this pls.....
		var noteColor = noteModel.getNoteType().contains(NoteType.KAT)
				? Color.BLUE
				: Color.RED;
		switch (noteModel.getTaikoNote()) {
			case CIRCLE:
				setImage(ShapeDrawer.CircleWithoutText(diameter, noteColor));
				break;
			case SLIDER:
				break;
			case SPINNER:
				break;
		}
	}

	@Override
	public void act() {
		// TODO - BPM and Time Signatures to determine how fast a note needs to go to be clicked in time
		this.move(-1);
	}
	
	public NoteModel getNoteModel() {
		return this.noteModel;
	}
}
