package com.mikebud.sockingdingers.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.mikebud.sockingdingers.database.DbPlayer;
import com.mikebud.sockingdingers.player.Player;
import com.mikebud.sockingdingers.team.BattingOrder;
import com.mikebud.sockingdingers.team.Team;
import com.mikebud.sockingdingers.utilities.GamestateToJson;

public class GameStateJsonTest {
	
    @BeforeAll
    static void setup() {
        try {
        	DbPlayer dbp = new DbPlayer();
            ScriptUtils.executeSqlScript(dbp.conn, new ClassPathResource("schema.sql"));
        } catch (Exception e ){
        	
        }
    }
    
	@Test
	public void testJsonifier() {
		
		DbPlayer dbp = new DbPlayer();
		
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
		
		GameState gs = new GameState(t1, t2);
		
		GamestateToJson.gameStateToJson(gs);


	}
}
