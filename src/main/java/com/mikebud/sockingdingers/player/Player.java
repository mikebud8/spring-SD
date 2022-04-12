package com.mikebud.sockingdingers.player;

import java.util.ArrayList;

public class Player {

	public String name;
	public int onBaseControl;
	public String speedInnings;
	public int cost;
	public boolean hasBatterStats = false;
	
	//in-game stuff
	public int battingOrder;
	public boolean isPitching;

	public String formattedRollTableString;
	
	public PlayerGameStats gameStats;
	public PlayerRollTableMap rollMap;
	public ArrayList<PlayerFieldingInfo> positionsArray;

	public Player() {
		//eventually bring in a json reader.

		gameStats = new PlayerGameStats();
		rollMap = new PlayerRollTableMap( hasBatterStats );
		positionsArray = new ArrayList<PlayerFieldingInfo>();
		
	}
	
	public void setRollTable() {
		if(name == null) {
			System.err.println("Setting stats for unknown player.");
		}
		formattedRollTableString = rollMap.setRollTable();
	}
	
}
