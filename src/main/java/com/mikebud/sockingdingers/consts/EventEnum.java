package com.mikebud.sockingdingers.consts;

import java.util.HashMap;

public enum EventEnum {
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
    private static HashMap<Integer, EventEnum> map = new HashMap<Integer, EventEnum>();
    
	private EventEnum(int idxIn) {
		enumIndex = idxIn;
	}
	
	public int getValue() {
		return enumIndex;
	}
	
    static {
        for (EventEnum s : EventEnum.values()) {
            map.put(s.enumIndex, s);
        }
    }

    public static EventEnum valueOf(int idx) {
        return map.get(idx);
    }
}
