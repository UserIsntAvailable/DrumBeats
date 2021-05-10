package actors;

import core.Config;
import graphics.ShapeDrawer;
import models.NoteModel;
import utils.NoteUtils;

public class NoteActor extends SmoothMover {
	//region Private Fields
	private final NoteModel noteModel;
	private static final Config config = Config.getInstance();
	//endregion
	
	//region Constructor
	public NoteActor( NoteModel noteModel) {
		this.noteModel = noteModel;

		// TODO - Set a different image depending in the taikoNote
		// TODO - Refactor this pls.....
		var noteColor = NoteUtils.getDrumType(noteModel).getColor();
		switch (noteModel.getTaikoNote()) {
			case CIRCLE:
				setImage(ShapeDrawer.CircleWithoutText(NoteUtils.getNoteDiameter(noteModel), noteColor));
				break;
			case SLIDER:
				break;
			case SPINNER:
				break;
		}
	}
	//endregion
	
	//region Public Methods
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
	//endregion
}
