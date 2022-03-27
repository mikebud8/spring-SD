package com.mikebud.sockingdingers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/roll")
	public Map<String, Integer> rollPage() {
		HashMap<String, Integer> map = new HashMap<>();
	    map.put("roll", rollDice(20,1,"Tester"));
	    
		return map;
	}
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	private int rollDice(int dSides, int nDice, String player) {

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = 0;
		// int dTotal = 0;

		for (int i = 1; i <= nDice; i++) {
			randomNum = ThreadLocalRandom.current().nextInt(1, dSides + 1);
			System.out.println(player + "'s roll equals " + randomNum);
			// dTotal = dTotal + randomNum;
		}
		return randomNum;
	}
}