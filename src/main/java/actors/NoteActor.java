package actors;

import enums.NoteType;
import graphics.ShapeDrawer;
import greenfoot.Color;
import models.NoteModel;

public class NoteActor extends SmoothMover {
	public NoteActor(int diameter, NoteModel actor) {
		// TODO - Set a different image depending in the taikoNote
		// TODO - Refactor this pls.....
		var noteColor = actor.getNoteType().contains(NoteType.KAT)
				? Color.BLUE
				: Color.RED;
		switch (actor.getTaikoNote()) {
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
		// TODO - Create formula to know how fast a note needs to move to reach the NoteCatcher in time
		// TODO - This movement need to be relative to the world size
		this.move(-1);
	}
}
