package core.models;

import java.util.ArrayList;
import java.util.Objects;

public class Map {
	//region Private Fields
	private final String name;
	private final String backgroundPath;
	private final String songPath;
	private final String artist;
	private final ArrayList<Score> scores;

	// TODO - Calculate it from the notes of the map or song length
	private String string = "";
	//endregion

	//region Constructor
	public Map(String name, String artist, String songPath, String backgroundPath) {
		this.name = name;
		this.artist = artist;
		this.songPath = songPath;
		this.backgroundPath = backgroundPath;

		scores = new ArrayList<>();
	}
	//endregion

	//region Getters
	public String getName() {
		return name;
	}

	public String getBackgroundPath() {
		return backgroundPath;
	}

	public String getSongPath() {
		return songPath;
	}

	public String getArtist() {
		return artist;
	}

	public String getLength() {
		return string;
	}

	public ArrayList<Score> getScores() {
		return scores;
	}
	//endregion

	//region Public Methods
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Map map = (Map) o;
		return name.equals(map.name)
				&& backgroundPath.equals(map.backgroundPath)
				&& songPath.equals(map.songPath)
				&& artist.equals(map.artist)
				&& scores.equals(map.scores)
				&& string.equals(map.string);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, backgroundPath, songPath, artist, scores, string);
	}

	public void addScore(Score score) {
		scores.add(score);
	}

	public void removeScore(Score score) {
		scores.remove(score);
	}
	//endregion
}
