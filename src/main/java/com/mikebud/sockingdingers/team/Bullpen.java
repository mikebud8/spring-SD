package com.mikebud.sockingdingers.team;

import java.util.ArrayList;

import com.mikebud.sockingdingers.player.Player;

public class Bullpen extends ArrayList<Player>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -593247092243325290L;

	public Player currentPitcher;
	public Bullpen() {
		currentPitcher = new Player(); 
	}
	
}
