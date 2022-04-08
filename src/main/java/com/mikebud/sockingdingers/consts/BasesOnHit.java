package com.mikebud.sockingdingers.consts;

public enum BasesOnHit{
	NO_ATBAT(-1),
	POPOUT(0),
	STRIKEOUT(0),
	GROUNDOUT(0),
	FLYOUT(0),
	WALK(1),
	SINGLE(1),
	SINGLEPLUS(1),
	TWOBAGGER(2),
	TRIPLE(3),
	DINGER(4)
	;
	
	private final int bases;
	private BasesOnHit(int bases) {
		this.bases = bases;
	}
	
	public int getValue() {
		return bases;
	}
}
