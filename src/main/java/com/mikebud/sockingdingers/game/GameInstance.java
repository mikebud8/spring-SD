package com.mikebud.sockingdingers.game;

import com.mikebud.sockingdingers.team.Team;

public class GameInstance {

	public long gameId;
	public GameState gs;
	
	public GameInstance(long gameIdIn) {
		gameId = gameIdIn;
		gs = new GameState();
	}
	
	public GameInstance(long gameIdIn, Team homeTeam, Team awayTeam) {
		gameId = gameIdIn;
		gs = new GameState(homeTeam, awayTeam);
	}
}
