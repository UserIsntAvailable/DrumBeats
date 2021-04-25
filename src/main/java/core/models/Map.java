package core.models;

import java.util.ArrayList;
import java.util.Objects;

public class Map {
	//region Private Fields
	private final String name;
	private final String backgroundFileName;
	private final String songFilename;
	private final String artist;
	private final String ID;
	private final String setID;
	private final ArrayList<Score> scores;

	// TODO - Calculate it from the notes of the map or song length
	private String length = "";
	//endregion

	//region Constructor
	public Map(String name, String artist, String songFilename, String backgroundFileName, String ID, String setID) {
		this.name = name;
		this.artist = artist;
		this.songFilename = songFilename;
		this.backgroundFileName = backgroundFileName;
		this.ID = ID;
		this.setID = setID;

		scores = new ArrayList<>();
	}
	//endregion

	//region Getters
	public String getName() {
		return name;
	}

	public String getBackgroundFileName() {
		return backgroundFileName;
	}

	public String getSongFilename() {
		return songFilename;
	}

	public String getArtist() {
		return artist;
	}

	public String getLength() {
		return length;
	}

	public ArrayList<Score> getScores() {
		return scores;
	}

	public String getID() {
		return ID;
	}

	public String getSetID() {
		return setID;
	}
	//endregion

	//region Public Methods
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Map map = (Map) o;
		return name.equals(map.name)
				&& backgroundFileName.equals(map.backgroundFileName)
				&& songFilename.equals(map.songFilename)
				&& artist.equals(map.artist)
				&& ID.equals(map.ID)
				&& setID.equals(map.setID)
				&& scores.equals(map.scores)
				&& length.equals(map.length);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, backgroundFileName, songFilename, artist, ID, setID, scores, length);
	}

	public void addScore(Score score) {
		scores.add(score);
	}

	public void removeScore(Score score) {
		scores.remove(score);
	}
	//endregion
}
