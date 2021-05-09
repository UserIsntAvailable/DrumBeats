package enums;

import greenfoot.Color;

public enum DrumType {
	INNER(Color.RED),
	OUTER(Color.BLUE),
	;
	
	//region Private Fields
	private final Color color;
	//endregion

	//region Constructor
	DrumType(Color color) {
		this.color = color;
	}
	//endregion
	
	//region Public Methods
	public Color getColor() {
		return color;
	}
	//endregion
}
