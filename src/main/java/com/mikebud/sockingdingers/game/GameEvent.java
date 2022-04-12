package com.mikebud.sockingdingers.game;

import java.util.HashMap;
import java.util.Map;
import com.mikebud.sockingdingers.consts.EventEnum;

public class GameEvent {
	
	public GameEvent(int scenarioId) {
		currentEvent = EventEnum.valueOf(scenarioId);
	}
	
	public EventEnum currentEvent;
}
