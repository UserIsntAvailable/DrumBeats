package handlers;

import actors.Counter;
import actors.NoteCatcher;
import events.NoteCatcherListener;
import events.NoteEvent;
import greenfoot.World;

public class ScoreHandler implements Handler {
	private final World world;
	private final Counter scoreCounter;
	private final Counter comboCounter;

	public ScoreHandler(World world) {
		this.world = world;
		this.scoreCounter = new Counter(50);
		this.comboCounter = new Counter(50);
		configure();
	}

	//region Handler
	@Override
	public long start() {
		addScoreUIObjects();
		world.getObjects(NoteCatcher.class).get(0).addNoteCatcherListener(new NoteCatcherListener() {
			@Override
			public void noteClicked(NoteEvent note) {
				scoreCounter.setValue(scoreCounter.getValue() + 10);
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
	//endregion
}
