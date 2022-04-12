package com.mikebud.sockingdingers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mikebud.sockingdingers.database.DbManager;
import com.mikebud.sockingdingers.game.GameInstance;
import com.mikebud.sockingdingers.game.GameEvent;
import com.mikebud.sockingdingers.game.GameState;
import com.mikebud.sockingdingers.game.GamesManager;
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
	GamesManager gamesManager;

	public GameController() {
		roller = new DiceRoller();
	}

	@GetMapping("/roll")
	public String rollPage(@RequestParam Long id, @RequestParam int scenarioId) {
		GameState gameState = gamesManager.getGameInstance(id);
		GameEvent scenario = new GameEvent(scenarioId);
		gameState.newRoll(roller.rollDice(20,1), scenario);
		return gameState.jsonifyGamestate();
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!\n";
	}

	@GetMapping("/newGame")
	public String newGame(@RequestParam int homeId, @RequestParam int awayId) {

		String uid = gamesManager.newGame(homeId, awayId);

		return uid;
	}

	@GetMapping("/getGame")
	public String getGame(@RequestParam String id) {
		return gamesManager.getGameStateString(id);
	}

	@GetMapping("/testGame")
	public String testGame() {

		String output = "";

		String id = newGame(1, 2);
		
		GameState gameState = gamesManager.getGameInstance(Long.parseLong(id));

		gameState.startGame();
		gameState.simGame();

		output = gameState.jsonifyGamestate();

		gamesManager.removeGameInstance(id);
		
		return output;
	}
}