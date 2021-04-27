package models;

public class Score {
	//region Private Fields
	private final int accuracy;
	private final int combo;
	private final String playerName;
	//endregion

	//region Constructor
	public Score(int accuracy, int combo, String playerName) {
		this.accuracy = accuracy;
		this.combo = combo;
		this.playerName = playerName;
	}
	//endregion

	//region Getters
	public int getAccuracy() {
		return accuracy;
	}

	public int getCombo() {
		return combo;
	}

	public String getPlayerName() {
		return playerName;
	}
	//endregion
}
