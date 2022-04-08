package com.mikebud.sockingdingers.game;

import java.io.Serializable;
import java.util.ArrayList;

import com.mikebud.sockingdingers.consts.BasesOnHit;
import com.mikebud.sockingdingers.consts.Scenario;
import com.mikebud.sockingdingers.team.Team;
import com.mikebud.sockingdingers.utilities.DiceRoller;
import com.mikebud.sockingdingers.utilities.GamestateToJson;

public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3656071385489429992L;

	public Inning inning;
	public Field field;
	
	private final int OUT = 0;
	
	enum TeamIndex {
		AWAY(0),
		HOME(1);
		
		public int index;
		
		private TeamIndex( int indexIn ) {
			index = indexIn;
		}
	}

	enum Advantage {
		NO_ADVANTAGE,
		PITCHER_ADVANTAGE,
		BATTER_ADVANTAGE
	}
	
	public Team homeTeam;
	public Team awayTeam;

	public ArrayList<Team> teamList = new ArrayList<Team>();
	
	public Advantage advantage = Advantage.NO_ADVANTAGE;
	public boolean gameOver = false;

	private TeamIndex battingTeam;
	private TeamIndex fieldingTeam;
	
	public GameState( ) {
		inning = new Inning();
		field = new Field();
		
		homeTeam = new Team();
		awayTeam = new Team();
	}

	public GameState(Team homeTeamIn, Team awayTeamIn) {
		homeTeam = homeTeamIn;
		awayTeam = awayTeamIn;
		inning = new Inning();
		field = new Field();
	}

	public void setHomeTeam( Team teamIn ) {
		homeTeam = teamIn;
	}

	public void setAwayTeam( Team teamIn ) {
		homeTeam = teamIn;
	}

	@Override
	public String toString() {
		return "Home Team: " + homeTeam.name +
				"Away Team: " + awayTeam.name;
	}

	public void newRoll(int rollDice, GameScenario gameScenario) {

		Scenario scenario = gameScenario.currentScenario;

		switch (scenario) {
		// For a pitcher roll, you're just trying to find who has advantage
		// on the swing.
		case PITCHER_ROLL:
			resolvePitcherRoll( rollDice );
			break;
		
		// Batter roll will resolve a swing. We'll inform the client about
		// the outcome. Any number of strategy/running options will occur.
		case BATTER_ROLL:
			BasesOnHit outcome = resolveBatterRoll( rollDice );
			
			if(OUT == outcome.getValue()) {
				
				inning.outs++;
				if ( inning.outs >= 3 ) {
					advanceInning();
				}
				
			} else {
				resolveBasepath( outcome ); 
			}
			battingTeam().bo.nextBatter();
			advantage = Advantage.NO_ADVANTAGE;
			break;
			
		case FIELDING_CHECK:
			break;
			
		case STEAL_CHECK:
			break;
			
		case STRATEGY_ROLL:
			break;
			
		default:
			break;
		}
	}

	private void resolveBasepath(BasesOnHit outcome) {
		int runs = field.hit(battingTeam().bo.getCurrentBatter(), outcome);
		battingTeam().scoreSheet.setScore(inning.inningNum, runs);
		battingTeam().ts.runs += runs;
	}

	private BasesOnHit resolveBatterRoll( int roll ) {
		
		BasesOnHit outcome = BasesOnHit.NO_ATBAT;
		
		if( advantage == Advantage.PITCHER_ADVANTAGE ) {
			outcome = fieldingTeam().bullpen.currentPitcher.rollMap.floorEntry(roll).getValue();
		} else if ( advantage == Advantage.BATTER_ADVANTAGE ) {
			outcome = battingTeam().bo.getCurrentBatter().rollMap.floorEntry(roll).getValue();
		} else {
			System.err.println("Batter Roll called before advantage declared.");
		}
		
		return outcome;
	}

	/*
	 * We're just setting the advantage during this event.
	 */
	private void resolvePitcherRoll( int roll ) {
		if( roll + fieldingTeam().bullpen.currentPitcher.onBaseControl
				> battingTeam().bo.getCurrentBatter().onBaseControl ) {
			advantage = Advantage.PITCHER_ADVANTAGE;
		} else {
			advantage = Advantage.BATTER_ADVANTAGE;
		}
		
	}

	public void startGame() {
		if(homeTeam != null && awayTeam != null) {
			battingTeam = TeamIndex.AWAY;
			fieldingTeam = TeamIndex.HOME;

			teamList.add(TeamIndex.AWAY.index, awayTeam);
			teamList.add(TeamIndex.HOME.index, homeTeam);
			System.out.println("Fielding Team = " + fieldingTeam().name);
			System.out.println("Fielding Team Starting Pitcher = " + fieldingTeam().bullpen.currentPitcher.name);

			System.out.println("Batting Team = " + battingTeam().name);
		}
	}
	
	public void simGame() {
		GameScenario scenario;
		while(!gameOver) {
			System.out.println("Game Over = " + gameOver
					+ "\nInning = " + inning.inningNum + ". isTop = " + inning.isTopOfInning + ". Outs = " + inning.outs );
			scenario = new GameScenario(1);
			newRoll(DiceRoller.rollDice(20,1), scenario);

			scenario = new GameScenario(2);
			newRoll(DiceRoller.rollDice(20,1), scenario);
		}
	}
	public String jsonifyGamestate() {
		return GamestateToJson.gameStateToJson(this);
	}

	private void advanceInning() {
		
		System.out.println("new inning. Home = " + homeTeam.ts.runs + " : Away = " + awayTeam.ts.runs);
		
		field.resetField();
		inning.outs = 0;
		
		if (inning.isTopOfInning)
		{
			inning.isTopOfInning = false;
			battingTeam = TeamIndex.HOME;
			fieldingTeam = TeamIndex.AWAY;

		} else {
			if (inning.inningNum >= 9 && homeTeam.ts.runs != awayTeam.ts.runs) {
				gameOver();
			} else {
				inning.inningNum++;
				inning.isTopOfInning = true;
				battingTeam = TeamIndex.AWAY;
				fieldingTeam = TeamIndex.HOME;
			}
		}
		
		if( !gameOver ) {
			System.out.println("It's " + (inning.isTopOfInning ? "top" : "bottom") + " of the " + inning.inningNum);
		}
	}

	private Team battingTeam() {
		return teamList.get(battingTeam.index);
	}
	
	private Team fieldingTeam() {
		return teamList.get(fieldingTeam.index);
	}
	
	private String gameOver() {
		String output = "";
		if (homeTeam.ts.runs > awayTeam.ts.runs) {
			output = homeTeam.name + " wins!!";
		} else if (awayTeam.ts.runs > homeTeam.ts.runs) {
			output = awayTeam.name + " wins!!";
		}
		gameOver = true;
		return output;
	}
}
