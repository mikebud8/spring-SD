package com.mikebud.sockingdingers.utilities;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikebud.sockingdingers.game.GameState;


public class GamestateToJson {

	public static String gameStateToJson(GameState gs ) {
		ObjectMapper mapper = new ObjectMapper();

		String jsonGS = "";
		
		try {

			//Convert object to JSON string
			jsonGS = mapper.writeValueAsString(gs);
			System.out.println(jsonGS);
			
			//Convert object to JSON string and pretty print
			jsonGS = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(gs);
			System.out.println(jsonGS);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jsonGS;
	}
}

