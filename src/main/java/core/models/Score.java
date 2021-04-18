package core.models;

public class Score {
	//region Private Fields
	private final int _accuracy;
	private final int _combo;
	private final String _playerName;
	//endregion

	//region Constructor
	public Score(int accuracy, int combo, String playerName) {
		_accuracy = accuracy;
		_combo = combo;
		_playerName = playerName;
	}
	//endregion

	//region Getters
	public int getAccuracy() {
		return _accuracy;
	}

	public int getCombo() {
		return _combo;
	}

	public String getPlayerName() {
		return _playerName;
	}
	//endregion
}
