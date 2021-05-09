package actors;

import IO.KeyboardManager;
import core.Action;
import core.Config;
import graphics.ShapeDrawer;
import greenfoot.Actor;
import greenfoot.Color;
import models.NoteModel;
import utils.ListUtils;
import utils.NoteUtils;
import utils.SoundUtils;

public class NoteCatcher extends Actor {
	private static final Config config = Config.getInstance();

	//region Constructor
	public NoteCatcher(int diameter) {
		setImage(ShapeDrawer.CircleWithoutText(diameter, new Color(100, 100, 100, 50)));
	}
	//endregion

	// region Public Methods
	@Override
	public void act() {
		var noteActors = this.getWorld().getObjects(NoteActor.class);
		if (noteActors.size() > 0) {
			var closestNote = noteActors.get(0);
			if (this.intersects(closestNote)) {
				if (!isNoteInMissArea(closestNote)) {
					this.handleKeyStrokes(closestNote);
					return;
				}
				this.removeNoteFromWorld(closestNote, SoundUtils::playMissSound);
			}
		}
	}
	//endregion

	//region Private Methods
	/*
	 I know Actor class has already an intersects method.
	 This is a lot faster though and I will probably will
	 change how close the other object needs to be to count
	 as an intersection.
	*/
	private boolean intersects(NoteActor note) {
		return Math.abs(note.getExactX() - this.getX()) <=
				this.getImage().getWidth() / 2.0 + note.getImage().getWidth() / 2.0;
	}

	private boolean isNoteInMissArea(NoteActor note) {
		return note.getExactX() + note.getImage().getWidth() <= this.getX();
	}

	private void handleKeyStrokes(NoteActor note) {
		verifyKeyStates(note, getDrumKeyStates(note.getNoteModel()));
	}

	private int getDrumKeyStates(NoteModel note) {
		var allDrumKeys = ListUtils.mapToKeyStrings(config.getValue("APP_DRUM_KEYS"));

		var drumKeysState = KeyboardManager.areKeysDown(allDrumKeys);

		var noteKeys = NoteUtils.getNoteKeys(note);

		int goodKeysPressed = 0;
		for (var noteKey : noteKeys) {
			if (drumKeysState.get(noteKey)) {
				goodKeysPressed++;
			}
			drumKeysState.remove(noteKey);
		}

		for (var isBadKeyPressed : drumKeysState.values()) {
			if (isBadKeyPressed) return -1;
		}

		return goodKeysPressed;
	}

	private void verifyKeyStates(NoteActor note, int keyState) {
		switch (keyState) {
			case 4:
				// TODO - Handle spinners
				break;
			case 2:
				// TODO - Handle big notes
				break;
			case 1:
				this.removeNoteFromWorld(note, () -> {
					// TODO - Show how precise the click was
				});
				break;
			case 0: // Just do nothing.
				break;
			case -1:
				this.removeNoteFromWorld(note, SoundUtils::playMissSound);
				break;
		}
	}

	private void removeNoteFromWorld(NoteActor note, Action action) {
		this.getWorld().removeObject(note);
		action.execute();
	}
	//endregion
}
