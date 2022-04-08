package com.mikebud.sockingdingers.game;

import java.util.HashMap;
import java.util.Map;
import com.mikebud.sockingdingers.consts.Scenario;

public class GameScenario {
	
	public GameScenario(int scenarioId) {
		currentScenario = Scenario.valueOf(scenarioId);
	}
	
	public Scenario currentScenario;
}
