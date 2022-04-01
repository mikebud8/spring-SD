package com.mikebud.sockingdingers.database;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

@Sql({"C:\\Users\\mikeb\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\socking-dingers\\src\\main\\resources\\schema.sql"})
public class DbPlayerTest {

	@Test
	public void testDatabase() {
		DbPlayer dbp = new DbPlayer();
		
		
		
		dbp.getPlayerFromDatabase(1);
	}
}
