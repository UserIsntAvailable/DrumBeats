package handlers;

import actors.Counter;
import actors.NoteCatcher;
import events.NoteCatcherListener;
import events.NoteEvent;
import greenfoot.World;
import utils.NoteUtils;

public class ScoreHandler implements Handler {
	//region Private Fields
	private final World world;
	private final Counter scoreCounter;
	private final Counter comboCounter;
	//endregion

	//region Constructor
	public ScoreHandler(World world) {
		this.world = world;
		this.scoreCounter = new Counter(50);
		this.comboCounter = new Counter(50);
		configure();
	}
	//endregion

	//region Handler
	@Override
	public long start() {
		addScoreUIObjects();
		world.getObjects(NoteCatcher.class).get(0).addNoteCatcherListener(new NoteCatcherListener() {
			@Override
			public void noteClicked(NoteEvent note) {
				scoreCounter.setValue(
						scoreCounter.getValue() +
								calculateScoreValue(note)
				);
				comboCounter.setValue(comboCounter.getValue() + 1);
			}

			@Override
			public void noteMissed(NoteEvent note) {
				comboCounter.setValue(0);
			}
		});
		return System.currentTimeMillis();
	}

	@Override
	public void configure() {
	}

	@Override
	public void close() {
	}
	//endregion

	//region Private Methods
	private void addScoreUIObjects() {
		world.addObject(
				scoreCounter,
				(int) (world.getWidth() / 1.05),
				world.getHeight() / 12
		);

		world.addObject(
				comboCounter,
				world.getWidth() / 22,
				(int) (world.getHeight() / 1.075)
		);
	}

	private int calculateScoreValue(NoteEvent note) {
		var baseAmount = 100;
		if (NoteUtils.isBigNote(note.getNote().getNoteModel()))
			if (note.getKeyState() == 2)
				return 100 * 2;
		return baseAmount;
	}
	//endregion
}
