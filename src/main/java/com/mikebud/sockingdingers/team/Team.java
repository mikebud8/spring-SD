package com.mikebud.sockingdingers.team;

public class Team {

	public String name;
	public BattingOrder bo;
	public Bullpen bullpen;
	
	public TeamScoresheet scoreSheet;
	public TeamStats ts;
	
	public Team() {
		name = "";
		bo = new BattingOrder(null, null, null, null, null, null, null, null, null);
		ts = new TeamStats();
		scoreSheet = new TeamScoresheet();
		bullpen = new Bullpen();
	}
	
	public Team(String nameIn, BattingOrder boIn) {
		name = nameIn;
		bo = boIn;
		ts = new TeamStats();
		scoreSheet = new TeamScoresheet();
		bullpen = new Bullpen();
	}
	
	public void set(Team copy) {
		this.name = copy.name;
		this.bo = copy.bo;
		this.bullpen = copy.bullpen;
		this.scoreSheet = copy.scoreSheet;
		this.ts = copy.ts;
	}
	
}
