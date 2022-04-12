package com.mikebud.sockingdingers.player;

import org.junit.jupiter.api.Test;

import com.mikebud.sockingdingers.consts.BasesOnHit;

public class PlayerRollTableMapTest {

	@Test
	void testRollTable() {
		PlayerRollTableMap prt = new PlayerRollTableMap( true );
		
		prt.popOut.min = -1;    
		prt.strikeOut.min = 1;  
		prt.strikeOut.max = 2; 
		prt.groundOut.min = 3; 
		prt.groundOut.max = 5; 
		prt.flyOut.min = 6;    
		prt.walk.min = 7;      
		prt.walk.max = 11;    
		prt.single.min = 12;  
		prt.single.max = 13;    
		prt.singlePlus.min = -1;
		prt.twoBagger.min = 14; 
		prt.twoBagger.max = 17;
		prt.triple.min = -1;    
		prt.dinger.min = 18;    
		prt.dinger.max = 20;
		
		prt.setRollTable();
		
		BasesOnHit outcome = prt.floorEntry(13).getValue();
		System.out.println("outcome = " + outcome);
		
		outcome = prt.floorEntry(1).getValue();
		System.out.println("outcome = " + outcome);
		
		prt.generateJsonString();
		
		prt.dinger.min = 20;
		
		prt.setRollTable();
		
		prt.generateJsonString();
	}
	
}
