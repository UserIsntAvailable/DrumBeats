package core.gameplay.models;

import java.util.ArrayList;
import java.util.Objects;

public class Map {
	//region Private Fields
	private final String _name;
	private final String _backgroundPath;
	private final String _songPath;
	private final String _artist;
	private final ArrayList<Score> _scores;

	// TODO - Calculate it from the notes of the map or song length
	private String _length = "";
	//endregion

	//region Constructor
	public Map(String name, String artist, String songPath, String backgroundPath) {
		_name = name;
		_artist = artist;
		_songPath = songPath;
		_backgroundPath = backgroundPath;

		_scores = new ArrayList<>();
	}
	//endregion

	//region Getters
	public String getName() {
		return _name;
	}

	public String getBackgroundPath() {
		return _backgroundPath;
	}

	public String getSongPath() {
		return _songPath;
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
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Map map = (Map) o;
		return _name.equals(map._name)
				&& _backgroundPath.equals(map._backgroundPath)
				&& _songPath.equals(map._songPath)
				&& _artist.equals(map._artist)
				&& _scores.equals(map._scores)
				&& _length.equals(map._length);
	}

	@Override
	public int hashCode() {
		return Objects.hash(_name, _backgroundPath, _songPath, _artist, _scores, _length);
	}

	public void addScore(Score score) {
		_scores.add(score);
	}

	public void removeScore(Score score) {
		_scores.remove(score);
	}
	//endregion
}
