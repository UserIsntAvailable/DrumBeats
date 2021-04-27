package actors;

public class NoteActor extends SmoothMover {
	public NoteActor() {
	}

	@Override
	public void act() {
		this.move(-1);
	}
}
