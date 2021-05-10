package events;

import java.util.EventListener;

public interface NoteCatcherListener extends EventListener {
	void noteClicked(NoteEvent note);

	void noteMissed(NoteEvent note);
}
