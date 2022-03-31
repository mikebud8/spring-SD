package com.mikebud.sockingdingers.utilities;

import java.util.concurrent.ThreadLocalRandom;

public class DiceRoller {

	public DiceRoller(){
		//no-op
	};
	
	public int rollDice(int dSides, int nDice) {

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = 0;
		// int dTotal = 0;

		for (int i = 1; i <= nDice; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(1, dSides + 1);
		}
		return randomNum;
	}
}
