package com.mikebud.sockingdingers.game;

public class GameInstance {

	public long gameId;
	public GameState gs;
	
	public GameInstance(long gameIdIn) {
		gameId = gameIdIn;
		gs = new GameState();
	}
}
