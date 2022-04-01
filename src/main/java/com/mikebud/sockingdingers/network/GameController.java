package com.mikebud.sockingdingers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mikebud.sockingdingers.database.DbPlayer;
import com.mikebud.sockingdingers.game.GameInstance;
import com.mikebud.sockingdingers.game.GameState;
import com.mikebud.sockingdingers.game.InstanceMap;
import com.mikebud.sockingdingers.player.Player;
import com.mikebud.sockingdingers.team.BattingOrder;
import com.mikebud.sockingdingers.team.Team;
import com.mikebud.sockingdingers.utilities.DiceRoller;
import com.mikebud.sockingdingers.utilities.GamestateToJson;

@RestController
public class GameController {

	private DiceRoller roller;

	@Autowired
	InstanceMap instanceMap;

	public GameController() {
		roller = new DiceRoller();
	}

	@GetMapping("/roll")
	public String rollPage(@RequestParam Long id, @RequestParam String homeAway) {

		instanceMap.get(id).gs.newRoll(roller.rollDice(20,1));
		return instanceMap.get(id).gs.getGameState();
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!\n";
	}

	@GetMapping("/newGame")
	public String newGame() {

		Long uid = instanceMap.getUniqueKey();
		
		System.out.println("UID is " + uid);
		
		if(!instanceMap.addGame(uid)) {
			// Need to alert the client in a better way.
			return "Error 42: No game made";
		}

		return uid.toString();
	}

	@GetMapping("/getGame")
	public String getGame(@RequestParam String id) {
		String output= "id = " + id + ". ";
		
		if(instanceMap.containsKey(Long.parseLong(id))) {
			output += "GameFound";
		} else {
			output += "Nothing here...Where'd you find this.";

			for(Long key : instanceMap.keySet()) {
				output += key.toString() + ", ";
			}
		}

		return output;
	}
	
	@GetMapping("/testGame")
	public String testGame(@RequestParam String id) {
		
		String output = "";

		DbPlayer dbp = new DbPlayer();
		
		if(instanceMap.containsKey(Long.parseLong(id))) {
			
			Player p1 = dbp.getPlayerFromDatabase(1);
			Player p2 = dbp.getPlayerFromDatabase(2);
			Player p3 = dbp.getPlayerFromDatabase(3);
			Player p4 = dbp.getPlayerFromDatabase(4);
			Player p5 = dbp.getPlayerFromDatabase(5);
			Player p6 = dbp.getPlayerFromDatabase(6);
			Player p7 = dbp.getPlayerFromDatabase(7);
			Player p8 = dbp.getPlayerFromDatabase(8);
			Player p9 = dbp.getPlayerFromDatabase(9);
			BattingOrder bo1 = new BattingOrder(p1, p2, p3, p4, p5, p6, p7, p8, p9);
			Team t1 = new Team("dingers", bo1);
			
			Player p11 = dbp.getPlayerFromDatabase(11);
			Player p12 = dbp.getPlayerFromDatabase(12);
			Player p13 = dbp.getPlayerFromDatabase(13);
			Player p14 = dbp.getPlayerFromDatabase(14);
			Player p15 = dbp.getPlayerFromDatabase(15);
			Player p16 = dbp.getPlayerFromDatabase(16);
			Player p17 = dbp.getPlayerFromDatabase(17);
			Player p18 = dbp.getPlayerFromDatabase(18);
			Player p19 = dbp.getPlayerFromDatabase(19);
			BattingOrder bo2 = new BattingOrder(p11,p12,p13,p14,p15,p16,p17,p18,p19);
			Team t2 = new Team("dongers", bo2);
			
			GameInstance instance = instanceMap.get(Long.parseLong(id));
			instance.gs.awayTeam = t1;
			instance.gs.homeTeam = t2;
			
			output += "GameFound";

			output = GamestateToJson.gameStateToJson(instance.gs);
			
		} else {
			output += "Nothing here...Where'd you find this.";

			for(Long key : instanceMap.keySet()) {
				output += key.toString() + ", ";
			}
		}
		//Player p1 = dbp.getPlayerFromDatabase(1);
		
		
		return output;
	}
}