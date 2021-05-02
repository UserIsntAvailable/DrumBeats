package handlers;

public interface Handler extends AutoCloseable {
	void start();
	void configure();
}
