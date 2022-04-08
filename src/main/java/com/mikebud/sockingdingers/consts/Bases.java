package com.mikebud.sockingdingers.consts;

public enum Bases {
	BOX(0, "Batter's Box"),
	FIRST(1, "First"),
	SECOND(2, "Second"),
	THIRD(3, "Third"),
	HOME(4, "Home");
	
	public int val;
	public String name;
	
	private Bases(int val, String name){
		this.val = val;
		this.name = name;
	}
}
