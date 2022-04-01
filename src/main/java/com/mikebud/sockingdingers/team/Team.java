package com.mikebud.sockingdingers.team;

public class Team {

	public String name;
	public BattingOrder bo;
	
	public TeamScoresheet scoreSheet;
	public TeamStats ts;
	
	public Team() {
		name = "";
		bo = new BattingOrder(null, null, null, null, null, null, null, null, null);
		ts = new TeamStats();
		scoreSheet = new TeamScoresheet();
	}
	
	public Team(String nameIn, BattingOrder boIn) {
		name = nameIn;
		bo = boIn;
		ts = new TeamStats();
		scoreSheet = new TeamScoresheet();
	}
}
