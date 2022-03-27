package com.mikebud.sockingdingers;

public class GameState {

	public long gameId;
	
	public int inning;
	
	enum HalfInning {
		AWAY_BATTING,
		HOME_BATTING
	}
}
