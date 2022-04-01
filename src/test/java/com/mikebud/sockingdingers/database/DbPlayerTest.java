package com.mikebud.sockingdingers.database;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

public class DbPlayerTest {
	
    @BeforeAll
    static void setup() {
        try {
        	DbPlayer dbp = new DbPlayer();
            ScriptUtils.executeSqlScript(dbp.conn, new ClassPathResource("schema.sql"));
        } catch (Exception e ){
        	
        }
    }
	@Test
	public void testDatabase() {
		DbPlayer dbp = new DbPlayer();
		
		
		
		dbp.getPlayerFromDatabase(1);
	}
}
