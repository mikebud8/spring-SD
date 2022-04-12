package com.mikebud.sockingdingers.game;

public class Inning {

	public int inningIdx;
	public boolean isTopOfInning;
	
	public int outs;
	
	public Inning() {
		inningIdx = 0;
		isTopOfInning = true;
		outs = 0;
	}
}
