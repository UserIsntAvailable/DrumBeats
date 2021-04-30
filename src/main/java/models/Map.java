package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// TODO - I can create a Hash property to know if the map was changed once created ( not really need it here tho )
public class Map {
	//region Private Fields

	/**
	 * The name of the map. It can be anything, but most likely it will be the song name.
	 */
	private final String name;

	/**
	 * The background image filename.
	 */
	private final String backgroundFileName;

	/**
	 * The song filename.
	 */
	private final String songFilename;

	/**
	 * The name of the artist that created the song.
	 */
	private final String artist;

	/**
	 * The map ID. Only one map can have that ID.
	 */
	private final String ID;

	/**
	 * The map set ID. All the map files that are part of the same **set** will have the same map set ID
	 */
	private final String setID;

	/**
	 * The notes that will appear on the map.
	 */
	private final List<NoteModel> notes;

	// TODO - Create a ScoreDatabase instead of saving the scores on the map object
	/**
	 * The scores that the player achieved.
	 */
	private final ArrayList<Score> scores;
	//endregion

	//region Constructor
	public Map(String name, String artist, String songFilename, String backgroundFileName, String ID, String setID, List<NoteModel> notes) {
		this.name = name;
		this.artist = artist;
		this.songFilename = songFilename;
		this.backgroundFileName = backgroundFileName;
		this.ID = ID;
		this.setID = setID;
		this.notes = notes;

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

	public int getLength() {
		var notesSize = notes.size();
		if (notesSize > 0) {
			return notes.get(notesSize - 1).getTime();
		}
		return 0;
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
	
	public List<NoteModel> getNotes() {
		return notes;
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
				&& notes.equals(map.notes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, backgroundFileName, songFilename, artist, ID, setID, notes, scores);
	}

	public void addScore(Score score) {
		scores.add(score);
	}

	public void removeScore(Score score) {
		scores.remove(score);
	}
	//endregion
}
