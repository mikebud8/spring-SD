package com.mikebud.sockingdingers.game;

import java.io.Serializable;

import com.mikebud.sockingdingers.team.Team;

public class GameState implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3656071385489429992L;
	
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
	
	public GameState(Team homeTeamIn, Team awayTeamIn) {
		homeTeam = homeTeamIn;
		awayTeam = awayTeamIn;
		inning = new Inning();
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

	public void newRoll(int rollDice) {
		// TODO Auto-generated method stub
		
	}

	public String getGameState() {
		// TODO Auto-generated method stub
		return null;
	}
}
