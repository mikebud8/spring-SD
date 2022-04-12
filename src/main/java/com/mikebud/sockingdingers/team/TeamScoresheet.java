package com.mikebud.sockingdingers.team;

import java.util.ArrayList;

public class TeamScoresheet {

	public ArrayList<Integer> scoresheet;
	
	public TeamScoresheet() {
		scoresheet = new ArrayList<Integer>();
		for( int i = 0; i < 9 ; i++ ) {
		scoresheet.add(0);
		}
	}
	
	public void setScore(int inningIdx, int score) {
	
		int cumulativeScore = scoresheet.get( inningIdx );
		scoresheet.set(inningIdx, (cumulativeScore + score));
	}
}
