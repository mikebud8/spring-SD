package com.mikebud.sockingdingers.player;

import com.mikebud.sockingdingers.consts.FieldingPositions;

public class PlayerFieldingInfo {

	FieldingPositions position;
	int bonus;

	public PlayerFieldingInfo( FieldingPositions pos, int bonusIn ) {
		position = pos;
		bonus = bonusIn;
	}
}