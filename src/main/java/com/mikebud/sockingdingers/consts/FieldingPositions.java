package com.mikebud.sockingdingers.consts;

public enum FieldingPositions {
	PITCHER(1, "Pitcher", "P"),
	CATCHER(2, "Catcher", "C"),
	FIRSTBASE(3, "First Baseman", "1B"),
	SECONDBASE(4, "Second Baseman", "2B"),
	THIRDBASE(5, "Third Baseman", "3B"),
	SHORTSTOP(6, "Shortstop", "SS"),
	LEFT(7, "Left Fielder", "LF"),
	CENTER(8, "Center Fielder", "CF"),
	RIGHT(9, "Right Fielder", "RF")
	;
	
	private final int positionNum;
	private final String positionName;
	private final String positionInitials;
	
	private FieldingPositions(int posNum, String posName, String posInitials) {
		this.positionNum = posNum;
		this.positionName = posName;
		this.positionInitials = posInitials;
	}
	
	public int getPositionNumber() {
		return positionNum;
	}
	
	public String getPositionName() {
		return positionName;
	}
	
	public String getPositionInitials() {
		return positionInitials;
	}
}
