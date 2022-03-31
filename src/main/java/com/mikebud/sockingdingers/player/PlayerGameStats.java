package com.mikebud.sockingdingers.player;

/************************************************
 * Essentially just a bunch of structs to keep
 * track of any one player's stats within a game.
 ***********************************************/
public class PlayerGameStats {

	public OffensiveStats oStats;
	public DefensiveStats dStats;
	public PitchingStats pStats;

	public PlayerGameStats() {
		oStats = new OffensiveStats();
		dStats = new DefensiveStats();
		pStats = new PitchingStats();
	}

	public class OffensiveStats{

		public int atBats = 0;
		public int hits = 0;
		public int outs = 0;

		public int strikeouts = 0;
		public int walks = 0;
		public int single = 0;
		// Can't call it double because that a reserved keyword.
		public int twoBagger = 0;
		public int triple = 0;
		public int dingers = 0;

		public int runsScored = 0;
		public int rbis = 0;

		public int steals = 0;
		public int caughtStealing = 0;

		public OffensiveStats() {

		}

	}

	public class PitchingStats{
		public int strikeouts = 0;
		public int walks = 0;

		public int inningsPitched = 0;

		public int dingersSurrendered = 0;

		public int saves = 0;
		public int blownSaves = 0;

		public PitchingStats() {

		}
	}

	public class DefensiveStats {
		public int putouts = 0;
		public int outfieldAssists = 0;

		public DefensiveStats() {

		}
	}

}
