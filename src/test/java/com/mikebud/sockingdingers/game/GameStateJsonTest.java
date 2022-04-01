package com.mikebud.sockingdingers.game;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.mikebud.sockingdingers.database.DbPlayer;
import com.mikebud.sockingdingers.player.Player;
import com.mikebud.sockingdingers.utilities.GamestateToJson;

@SpringBootTest
@SpringBootConfiguration
@Sql("/schema.sql")
public class GameStateJsonTest {

	@Test
	public void testJsonifier() {
		
		DbPlayer dbp = new DbPlayer();
		Player p1 = dbp.getPlayerFromDatabase(1);
		

		GameState gs = new GameState();
		GamestateToJson.gameStateToJson(gs);


	}
}
