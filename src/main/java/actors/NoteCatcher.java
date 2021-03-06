package actors;

import IO.KeyboardManager;
import core.Config;
import events.NoteCatcherListener;
import events.NoteEvent;
import graphics.ShapeDrawer;
import greenfoot.Actor;
import greenfoot.Color;
import models.NoteModel;
import utils.ListUtils;
import utils.NoteUtils;

import java.util.ArrayList;
import java.util.List;

public class NoteCatcher extends Actor {
	//region Private Fields
	private static final Config config = Config.getInstance();

	private final List<NoteCatcherListener> noteCatcherListeners = new ArrayList<>();
	//endregion

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
					this.notifyKeystrokes(closestNote);
					return;
				}
				fireNoteMissedEvent(new NoteEvent(closestNote, 0));
			}
		}
	}

	public void addNoteCatcherListener(NoteCatcherListener listener) {
		noteCatcherListeners.add(listener);
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
		return note.getExactX() + note.getImage().getWidth() / 1.5 <= this.getX();
	}

	private void notifyKeystrokes(NoteActor note) {
		notifyListeners(note, getDrumKeyStates(note.getNoteModel()));
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

	private void notifyListeners(NoteActor note, int keyState) {
		if (keyState != 0) {
			if (keyState > 0) {
				fireNoteClickedEvent(new NoteEvent(note, keyState));
			}
			else {
				fireNoteMissedEvent(new NoteEvent(note, keyState));
			}
		}
	}

	private void fireNoteClickedEvent(NoteEvent e) {
		for (var l : noteCatcherListeners) {
			l.noteClicked(e);
		}
	}

	private void fireNoteMissedEvent(NoteEvent e) {
		for (var l : noteCatcherListeners) {
			l.noteMissed(e);
		}
	}
	//endregion
}
