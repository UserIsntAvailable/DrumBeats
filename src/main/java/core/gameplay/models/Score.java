package core.gameplay.models;

public class Score {
	private final int _accuracy;
	private final int _combo;
	private final String _playerName;

	public Score(int accuracy, int combo, String playerName) {
		_accuracy = accuracy;
		_combo = combo;
		_playerName = playerName;
	}

	public int getAccuracy() {
		return _accuracy;
	}

	public int getCombo() {
		return _combo;
	}

	public String getPlayerName() {
		return _playerName;
	}
}
