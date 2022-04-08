package com.mikebud.sockingdingers.database;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;

import com.mikebud.sockingdingers.consts.FieldingPositions;
import com.mikebud.sockingdingers.player.Player;
import com.mikebud.sockingdingers.player.PlayerFieldingInfo;
import com.mikebud.sockingdingers.team.BattingOrder;
import com.mikebud.sockingdingers.team.Bullpen;
import com.mikebud.sockingdingers.team.Team;

public class DbPlayer {
	// JDBC driver name and database URL 
	//static final String JDBC_DRIVER = "org.h2.Driver";   
	static final String DB_URL = "jdbc:h2:mem:PlayerData";  

	//  Database credentials 
	static final String USER = "sa"; 
	static final String PASS = ""; 

	public Connection conn; 
	public Statement stmt;

	public DbPlayer() {

		try { 
			// STEP 1: Register JDBC driver 
			//Class.forName(JDBC_DRIVER); 

			//STEP 2: Open a connection 
			System.out.println("Connecting to database..."); 
			conn = DriverManager.getConnection(DB_URL,USER,PASS); 
			System.out.println("Connected database successfully..."); 
		} catch(SQLException se) { 
			//Handle errors for JDBC 
			se.printStackTrace(); 
		} catch(Exception e) { 
			//Handle errors for Class.forName 
			e.printStackTrace(); 
		}

	}

	public Player getPlayerFromDatabase(int id) {
		Player p = new Player();

		try {

			//conn = DriverManager.getConnection(DB_URL,USER,PASS);

			// STEP 3: Execute a query 
			stmt = conn.createStatement(); 
			String sql = "SELECT * FROM PLAYERS WHERE Serial = " + id; 
			ResultSet rs = stmt.executeQuery(sql); 

			// STEP 4: Extract data from result set 
			while(rs.next()) { 
				// Retrieve by column name 
				p.name  = (rs.getString("FirstName") + " " + rs.getString("LastName")); 
				p.cost = rs.getInt("Cost");

				p.onBaseControl = rs.getInt("Control");
				p.speedInnings = rs.getString("Innings");


				// TODO positions
				for(int i = 0; i < rs.getInt("numPositions"); i++) {
					String position = rs.getString("Position_" + (i + 1));
					int bonus = rs.getInt("Pos_" + (i + 1) + "_bonus");
					PlayerFieldingInfo pfi = new PlayerFieldingInfo(FieldingPositions.valueOf(position), bonus);
					p.positionsArray.add(i, pfi);
				}

				// Stats
				if(rs.getInt("PO_min") != 0) {
					p.rollMap.popOut.min = rs.getInt("PO_min");
					p.rollMap.popOut.max = rs.getInt("PO_max");
				}

				if(rs.getInt("SO_min") != 0) {
					p.rollMap.strikeOut.min = rs.getInt("SO_min");
					p.rollMap.strikeOut.max = rs.getInt("SO_max");
				}

				if(rs.getInt("GB_min") != 0) {
					p.rollMap.groundOut.min = rs.getInt("GB_min");
					p.rollMap.groundOut.max = rs.getInt("GB_max");
				}

				if(rs.getInt("FB_min") != 0) {
					p.rollMap.flyOut.min = rs.getInt("FB_min");
					p.rollMap.flyOut.max = rs.getInt("FB_max");
				}

				if(rs.getInt("W_min") != 0) {
					p.rollMap.walk.min = rs.getInt("W_min");
					p.rollMap.walk.max = rs.getInt("W_max");
				}

				if(rs.getInt("S_min") != 0) {
					p.rollMap.single.min = rs.getInt("S_min");
					p.rollMap.single.max = rs.getInt("S_max");
				}

				if(rs.getInt("SPlus_min") != 0) {
					p.rollMap.singlePlus.min = rs.getInt("SPlus_min");
					p.rollMap.singlePlus.max = rs.getInt("SPlus_max");
				}

				if(rs.getInt("DB_min") != 0) {
					p.rollMap.twoBagger.min = rs.getInt("DB_min");
					p.rollMap.twoBagger.max = rs.getInt("DB_max");
				}

				if(rs.getInt("TR_min") != 0) {
					p.rollMap.triple.min = rs.getInt("TR_min");
					p.rollMap.triple.max = rs.getInt("TR_max");
				}

				if(rs.getInt("HR_min") != 0) {
					p.rollMap.dinger.min = rs.getInt("HR_min");
					p.rollMap.dinger.max = rs.getInt("HR_max");
				}

				p.rollMap.setStats();
			} 
			// STEP 5: Clean-up environment 
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

	public Team getTeamFromDatabase(int id) {
		Team team = new Team();


		try {

			//conn = DriverManager.getConnection(DB_URL,USER,PASS);

			// STEP 3: Execute a query 
			stmt = conn.createStatement(); 
			String sql = "SELECT * FROM TEAMS WHERE TeamKey = " + id; 
			ResultSet rs = stmt.executeQuery(sql); 

			// STEP 4: Extract data from result set 
			while(rs.next()) { 
				team.name = rs.getString("Name");
				
				BattingOrder bo = new BattingOrder(
						getPlayerFromDatabase(rs.getInt("p1_id")),
						getPlayerFromDatabase(rs.getInt("p2_id")),
						getPlayerFromDatabase(rs.getInt("p3_id")),
						getPlayerFromDatabase(rs.getInt("p4_id")),
						getPlayerFromDatabase(rs.getInt("p5_id")),
						getPlayerFromDatabase(rs.getInt("p6_id")),
						getPlayerFromDatabase(rs.getInt("p7_id")),
						getPlayerFromDatabase(rs.getInt("p8_id")),
						getPlayerFromDatabase(rs.getInt("p9_id")));
				
				team.bo = bo;
				Player pitcher = getPlayerFromDatabase(rs.getInt("pitcher_id"));
				pitcher.rollMap.setStats();
				System.out.println( pitcher.rollMap.toString() );
				team.bullpen.add(pitcher);
				
			}
			// STEP 5: Clean-up environment 
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return team;
	}
}