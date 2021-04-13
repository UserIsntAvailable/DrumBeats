package core.gameplay.models;

import java.util.ArrayList;

public class Map {
	//region Private Fields
	private final String _name;
	private final String _backgroundImagePath;
	private final String _songName;
	private final String _artist;
	private final String _length;
	private final ArrayList<Score> _scores;
	//endregion

	//region Constructor
	public Map(String name, String backgroundImagePath, String songName, String artist, String length) {
		_name = name;
		_backgroundImagePath = backgroundImagePath;
		_songName = songName;
		_artist = artist;
		_length = length;

		_scores = new ArrayList<>();
	}
	//endregion

	//region Getters
	public String getName() {
		return _name;
	}

	public String getBackgroundImagePath() {
		return _backgroundImagePath;
	}

	public String getSongName() {
		return _songName;
	}

	public String getArtist() {
		return _artist;
	}

	public String getLength() {
		return _length;
	}

	public ArrayList<Score> getScores() {
		return _scores;
	}
	//endregion

	//region Public Methods
	public void addScore(Score score) {
		_scores.add(score);
	}

	public void removeScore(Score score) {
		_scores.remove(score);
	}
	//endregion
}
