package com.mikebud.sockingdingers.consts;

import java.util.HashMap;

public enum Scenario {
	NO_SCENARIO(0),
	PITCHER_ROLL(1),
	BATTER_ROLL(2),
	FIELDING_CHECK(3),
	STEAL_CHECK(4),
	SWITCH_PITCHER(5),
	PINCH_HITTER(6),
	FIELDER_SUB(7),
	STRATEGY_ROLL(8);
	
	private final int enumIndex;
    private static HashMap<Integer, Scenario> map = new HashMap<Integer, Scenario>();
    
	private Scenario(int idxIn) {
		enumIndex = idxIn;
	}
	
	public int getValue() {
		return enumIndex;
	}
	
    static {
        for (Scenario s : Scenario.values()) {
            map.put(s.enumIndex, s);
        }
    }

    public static Scenario valueOf(int idx) {
        return map.get(idx);
    }
}
