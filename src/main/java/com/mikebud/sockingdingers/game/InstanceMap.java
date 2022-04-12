package com.mikebud.sockingdingers.game;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mikebud.sockingdingers.team.Team;

@Service
@Scope("singleton")
public class InstanceMap extends HashMap<Long, GameInstance>{
	
	// topographical representation of the earths surface, drawn to scale, as those seen from above.
	/**
	 * 
	 */
	private static final long serialVersionUID = -8367102990418103377L;
	
	private int numGames = 0;
	private final int MAX_GAMES = 10;
	
	public InstanceMap() {
		
	}
	
	// I'm sure this will work.
	public Long getUniqueKey() {
		Long uid = (System.currentTimeMillis() << 20) | (System.nanoTime() & ~9223372036854251520L);
		
		while(this.containsKey(uid)) {
			uid = (System.currentTimeMillis() << 20) | (System.nanoTime() & ~9223372036854251520L);
		}
		
		return uid; 
	}
	
	public boolean addGame(Long uid) {
		boolean worked = false;
		
		System.out.println(" in Addgame. uid = " + uid);
		
		if (numGames <= MAX_GAMES) {
			this.put(uid, new GameInstance(uid));
			worked = true;
			numGames++;
		}
		
		return worked;
	}
	
	public boolean addGame(Long uid, Team homeTeam, Team awayTeam) {
		boolean worked = false;
		
		System.out.println(" in Addgame. uid = " + uid);
		
		if (numGames <= MAX_GAMES) {
			this.put(uid, new GameInstance(uid, homeTeam, awayTeam));
			worked = true;
			numGames = this.size();
		}
		
		return worked;
	}
}