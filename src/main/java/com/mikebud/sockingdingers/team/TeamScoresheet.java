package com.mikebud.sockingdingers.team;

import java.util.ArrayList;

public class TeamScoresheet {

	public ArrayList<Integer> scoresheet;
	
	public TeamScoresheet() {
		scoresheet = new ArrayList<Integer>();
	}
	
	public void setScore(int inning, int score) {
		scoresheet.add(inning, score);
	}
}
