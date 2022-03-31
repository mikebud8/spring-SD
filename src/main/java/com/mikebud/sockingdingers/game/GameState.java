package com.mikebud.sockingdingers.game;

public class GameState {

	public long gameId;
	
	public Inning inning;

	enum HalfInning {
		AWAY_BATTING,
		HOME_BATTING
	}

	public Team homeTeam;
	public Team awayTeam;

	public GameState( long gameIdIn ) {
		gameId = gameIdIn;
		inning = new Inning();
		homeTeam = new Team();
		awayTeam = new Team();
	}

	public void setHomeTeam( Team teamIn ) {
		homeTeam = teamIn;
	}

	public void setAwayTeam( Team teamIn ) {
		homeTeam = teamIn;
	}

}
