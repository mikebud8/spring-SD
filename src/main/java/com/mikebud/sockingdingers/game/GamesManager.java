package com.mikebud.sockingdingers.game;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mikebud.sockingdingers.database.DbManager;
import com.mikebud.sockingdingers.team.Team;

@Service
@Scope("singleton")
public class GamesManager {

	private InstanceMap instanceMap;
	private DbManager databaseMgr;
	
	public GamesManager() {
		instanceMap = new InstanceMap();
		databaseMgr = new DbManager();
	}
	
	public InstanceMap getInstanceMap() { 
		return instanceMap;
	}
	
	public DbManager getDbManager() {
		return databaseMgr;
	}
	
	public String newGame(int homeUserId, int awayUserId) {
		
		Team homeTeam = databaseMgr.getTeamFromDatabase(homeUserId);
		Team awayTeam = databaseMgr.getTeamFromDatabase(awayUserId);
		
		Long uid = instanceMap.getUniqueKey();
		
		System.out.println("UID is " + uid);

		if(!instanceMap.addGame(uid, homeTeam, awayTeam)) {
			// Need to alert the client in a better way.
			return "Error 42: No game made";
		}
		
		return uid.toString();
	}
	
	public GameState getGameInstance(Long uid) {
		return instanceMap.get(uid).gs;
	}
	
	public String getGameStateString(String uid) {
		String output = "";
		
		if(instanceMap.containsKey(Long.parseLong(uid))) {
			output = instanceMap.get(Long.parseLong(uid)).gs.jsonifyGamestate();
		} else {
			output += "Nothing here...Where'd you find this.";

			for(Long key : instanceMap.keySet()) {
				output += key.toString() + ", ";
			}
		}
		
		return output;
	}
	
	public void removeGameInstance(String uid) {
		instanceMap.remove(Long.parseLong(uid));
	}
	
}
