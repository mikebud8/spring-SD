package com.mikebud.sockingdingers.team;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.mikebud.sockingdingers.database.DbManager;

public class TeamDatabaseTest {

    @BeforeAll
    static void setup() {
        try {
        	DbManager dbp = new DbManager();
            ScriptUtils.executeSqlScript(dbp.conn, new ClassPathResource("schema.sql"));
        } catch (Exception e ){
        	
        }
    }
	
	@Test
	void testTeamDatabase() {
		
		DbManager dbp = new DbManager();
		Team t = dbp.getTeamFromDatabase(1);
		System.out.println("team1 = " + t.name);
	}
	
}
