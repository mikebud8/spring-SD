package com.mikebud.sockingdingers.game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mikebud.sockingdingers.consts.BasesOnHit;
import com.mikebud.sockingdingers.player.Player;

public class FieldTest {

	@Test
	public void testField() {
		Field f = new Field();
		Player p = new Player();
		p.name = "Who";
		f.hit(p, BasesOnHit.SINGLE);
		
		Player p2 = new Player();
		p2.name = "What";
		
		f.hit(p2, BasesOnHit.SINGLE);
		
		Player p3 = new Player();
		p3.name = "Rattlin Bogg";
		
		int runs = f.hit(p3, BasesOnHit.TRIPLE);
		
		f.getFieldStatus();
		assertTrue(runs == 2);
	}
	
	@Test
	public void testDinger() {

		Field f = new Field();
		Player p = new Player();
		p.name = "Who";
		int runs = f.hit(p, BasesOnHit.DINGER);
		
		assertTrue( runs == 1 );
	}
	
	@Test
	public void testWalks() {

		Field f = new Field();
		Player p = new Player();
		p.name = "Who";
		f.hit(p, BasesOnHit.SINGLE);
		
		Player p2 = new Player();
		p2.name = "What";
		
		f.hit(p2, BasesOnHit.TWOBAGGER);
		
		Player p3 = new Player();
		p3.name = "Rattlin Bogg";
		
		int runs = f.hit(p3, BasesOnHit.WALK);
		f.getFieldStatus();
		assertTrue( runs == 0 );
		
		f.resetField();
		
		runs = 0;

		Player p4 = new Player();
		p.name = "Who";
		runs = f.hit(p4, BasesOnHit.WALK);
		
		Player p5 = new Player();
		p2.name = "What";
		
		runs = f.hit(p5, BasesOnHit.WALK);
		
		Player p6 = new Player();
		p3.name = "Donk";

		runs = f.hit(p6, BasesOnHit.WALK);
		
		Player p7 = new Player();
		p3.name = "Rattlin Bogg";
		
		runs = f.hit(p7, BasesOnHit.WALK);
		
		assertTrue(runs == 1);
	}
}
