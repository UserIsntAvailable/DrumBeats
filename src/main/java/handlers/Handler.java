package handlers;

public interface Handler extends AutoCloseable {
	/**
	 * Start set in up what the handles is supposed to do.
	 * @return The time when this method finished, in milliseconds.
	 */
	long start();
	void configure();
}
