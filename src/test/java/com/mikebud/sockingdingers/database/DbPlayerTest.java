package com.mikebud.sockingdingers.database;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.tools.RunScript;
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
