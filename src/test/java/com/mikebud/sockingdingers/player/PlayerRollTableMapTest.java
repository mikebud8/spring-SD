package com.mikebud.sockingdingers.player;

import org.junit.jupiter.api.Test;

import com.mikebud.sockingdingers.consts.BasesOnHit;

public class PlayerRollTableMapTest {

	@Test
	void testRollTable() {
		PlayerRollTableMap prt = new PlayerRollTableMap();
		
		prt.popOut.min = -1;    
		prt.strikeOut.min = 1; 
		prt.groundOut.min = 3; 
		prt.flyOut.min = 6;    
		prt.walk.min = -7;      
		prt.single.min = 12;    
		prt.singlePlus.min = -1;
		prt.twoBagger.min = 14; 
		prt.triple.min = -1;    
		prt.dinger.min = 18;
		
		prt.setStats();
		
		BasesOnHit outcome = prt.floorEntry(13).getValue();
		System.out.println("outcome = " + outcome);
		
		outcome = prt.floorEntry(1).getValue();
		System.out.println("outcome = " + outcome);
	}
	
}
