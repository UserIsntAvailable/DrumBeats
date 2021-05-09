package actors;

import core.Config;
import graphics.ShapeDrawer;
import models.NoteModel;
import utils.NoteUtils;

public class NoteActor extends SmoothMover {
	private final NoteModel noteModel;
	private static final Config config = Config.getInstance();

	public NoteActor(int diameter, NoteModel noteModel) {
		this.noteModel = noteModel;

		// TODO - Set a different image depending in the taikoNote
		// TODO - Refactor this pls.....
		var noteColor = NoteUtils.getDrumType(noteModel).getColor();
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
		this.move(
				config.getValue(Double.class, "NOTES_MOVEMENT_SPEED")
						* config.getValue(Double.class, "APP_FRAMES_DELTA_TIME")
		);
	}

	public NoteModel getNoteModel() {
		return this.noteModel;
	}
}
