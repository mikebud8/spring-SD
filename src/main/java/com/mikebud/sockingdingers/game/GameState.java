package com.mikebud.sockingdingers.game;

import com.mikebud.sockingdingers.team.Team;

public class GameState {
	
	public Inning inning;

	enum HalfInning {
		AWAY_BATTING,
		HOME_BATTING
	}

	public Team homeTeam;
	public Team awayTeam;

	public GameState( ) {
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

	@Override
	public String toString() {
		return "Home Team: " + homeTeam.name +
				"Away Team: " + awayTeam.name;
	}
}
