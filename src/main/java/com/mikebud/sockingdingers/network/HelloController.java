package com.mikebud.sockingdingers.network;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikebud.sockingdingers.utilities.DiceRoller;

@RestController
public class HelloController {
	
	private DiceRoller roller;
	
	public HelloController() {
		roller = new DiceRoller();
	}
	
	@GetMapping("/roll")
	public Map<String, Integer> rollPage() {
		HashMap<String, Integer> map = new HashMap<>();
	    map.put("roll", roller.rollDice(20,1));
	    
		return map;
	}
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!\n" +
				SockingDingersApplication.gi.toString();
	}
	
}