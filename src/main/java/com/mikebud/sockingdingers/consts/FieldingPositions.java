package com.mikebud.sockingdingers.consts;

public enum FieldingPositions {
	STARTER(0, "Starter", "SP"),
	RELIEVER(1, "Reliever", "RP"),
	CLOSER(2, "Closer", "CP"),
	CATCHER(3, "Catcher", "C"),
	FIRSTBASE(4, "First Baseman", "1B"),
	SECONDBASE(5, "Second Baseman", "2B"),
	THIRDBASE(6, "Third Baseman", "3B"),
	SHORTSTOP(7, "Shortstop", "SS"),
	LEFT(8, "Left Fielder", "LF"),
	CENTER(9, "Center Fielder", "CF"),
	RIGHT(10, "Right Fielder", "RF"),
	DH(11, "Designated Hitter", "DH")
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
