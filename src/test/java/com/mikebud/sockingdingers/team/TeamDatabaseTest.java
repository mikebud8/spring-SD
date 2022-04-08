package com.mikebud.sockingdingers.team;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.mikebud.sockingdingers.database.DbPlayer;

public class TeamDatabaseTest {

    @BeforeAll
    static void setup() {
        try {
        	DbPlayer dbp = new DbPlayer();
            ScriptUtils.executeSqlScript(dbp.conn, new ClassPathResource("schema.sql"));
        } catch (Exception e ){
        	
        }
    }
	
	@Test
	void testTeamDatabase() {
		
		DbPlayer dbp = new DbPlayer();
		Team t = dbp.getTeamFromDatabase(1);
		System.out.println("team1 = " + t.name);
	}
	
}
