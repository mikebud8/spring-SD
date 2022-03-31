package com.mikebud.sockingdingers.player;

import java.util.ArrayList;

public class Player {

	public String name;
	public int onBaseControl;
	public int speedInnings;
	public int cost;

	//in-game stuff
	public int battingOrder;
	public boolean isPitching;

	public PlayerGameStats gameStats;
	public PlayerRollTableMap rollMap;
	public ArrayList<PlayerFieldingInfo> positionsArray;

	public Player() {
		//eventually bring in a json reader.

		gameStats = new PlayerGameStats();
		rollMap = new PlayerRollTableMap();
		positionsArray = new ArrayList<PlayerFieldingInfo>();
		
	}
}
