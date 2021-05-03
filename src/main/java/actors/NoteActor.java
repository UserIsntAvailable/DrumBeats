package actors;

import core.Config;
import enums.NoteType;
import graphics.ShapeDrawer;
import greenfoot.Color;
import greenfoot.Greenfoot;
import models.NoteModel;

import java.util.List;

public class NoteActor extends SmoothMover {
	private final NoteModel noteModel;
	private static final Config config = Config.getInstance();
	
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
		this.move(
				config.getValue(Double.class, "NOTES_MOVEMENT_SPEED")
						* config.getValue(Double.class, "APP_FRAMES_DELTA_TIME")
		);

		// Just testing, I need to refactor this
		var noteCatcher = this.getWorld().getObjects(NoteCatcher.class).get(0);

		if (this.intersects(noteCatcher)) {
			if (noteModel.getNoteType().contains(NoteType.KAT)) {
				removeObjectIfKeysPress(List.of("d", "k"));
			}
			else {
				removeObjectIfKeysPress(List.of("f", "j"));
			}
		}
	}
	
	public NoteModel getNoteModel() {
		return this.noteModel;
	}

	private void removeObjectIfKeysPress(List<String> keys) {
		for (var key: keys) {
			if (Greenfoot.isKeyDown(key)) {
				this.getWorld().removeObject(this);
			}
		}
	}
}
