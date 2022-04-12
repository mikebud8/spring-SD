package com.mikebud.sockingdingers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mikebud.sockingdingers.database.DbManager;
import com.mikebud.sockingdingers.game.GameInstance;
import com.mikebud.sockingdingers.player.Player;

@SpringBootApplication
public class SockingDingersApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SockingDingersApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");
			DbPlayer dbp = new DbPlayer();
			Player p1 = dbp.getPlayerFromDatabase(1);
			p1.rollMap.setStats();
			System.out.println(p1.name + "\nPositions:\n" + p1.positionsArray.toString() + ".\nRolls:\n" + p1.rollMap.toString());

		};
	}*/
}
