package com.mikebud.sockingdingers.game;

import org.junit.jupiter.api.Test;

import com.mikebud.sockingdingers.player.Player;

public class BattingOrderTest {

	@Test
	void testBORollover() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		Player p5 = new Player();
		Player p6 = new Player();
		Player p7 = new Player();
		Player p8 = new Player();
		Player p9 = new Player();

		p1.name = "batter1";
		p2.name = "batter2";
		p3.name = "batter3";
		p4.name = "batter4";
		p5.name = "batter5";
		p6.name = "batter6";
		p7.name = "batter7";
		p8.name = "batter8";
		p9.name = "batter9";

		BattingOrder bo = new BattingOrder(p1, p2, p3, p4, p5, p6, p7, p8, p9);
		
		Player cb = new Player();
		for(int i = 0; i < 48; i++) {
			cb = bo.nextBatter();
			System.out.println("Batter is " + cb.name);
		}
		
		Player p10 = new Player();
		p10.name = "batter10";
		
		System.out.println("\n\n\n\n");
		System.out.println("Batter was " + bo.getOrder().get(4).name);
		
		System.out.println("\n\n\n\n");
		bo.getOrder().set(4, p10);
		System.out.println("Batter is " + bo.getOrder().get(4).name);
		System.out.println("\n\n\n\n");
		
		for(int i = 0; i < 48; i++) {
			cb = bo.nextBatter();
			System.out.println("Batter is " + cb.name);
		}
		
	}
}
