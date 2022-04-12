package com.mikebud.sockingdingers.database;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

public class DbManagerTest {
	
    @BeforeAll
    static void setup() {
        try {
        	DbManager dbp = new DbManager();
            ScriptUtils.executeSqlScript(dbp.conn, new ClassPathResource("schema.sql"));
        } catch (Exception e ){
        	
        }
    }
    
	@Test
	public void testDatabase() {
		DbManager dbp = new DbManager();
		
		
		
		dbp.getPlayerFromDatabase(1);
	}
}
