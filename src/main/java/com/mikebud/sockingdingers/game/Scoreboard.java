package com.mikebud.sockingdingers.game;

import com.mikebud.sockingdingers.team.TeamScoresheet;

public class Scoreboard {
	private TeamScoresheet homeTeamScoresheet;
	private TeamScoresheet awayTeamScoresheet;
	
	public Scoreboard(TeamScoresheet homeTeamSheetIn, TeamScoresheet awayTeamSheetIn) {
		homeTeamScoresheet = homeTeamSheetIn;
		awayTeamScoresheet = awayTeamSheetIn;
	}
	
	public void setHomeScore(int inning, int score) {
		homeTeamScoresheet.setScore(inning, score);
	}

	public void setAwayScore(int inning, int score) {
		awayTeamScoresheet.setScore(inning, score);
	}
}
