package com.mikebud.sockingdingers.player;

import java.io.Serializable;

import com.mikebud.sockingdingers.consts.FieldingPositions;

public class PlayerFieldingInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4236548920870762060L;
	
	public FieldingPositions position;
	public int bonus;

	public PlayerFieldingInfo( FieldingPositions pos, int bonusIn ) {
		position = pos;
		bonus = bonusIn;
	}
	
	@Override
	public String toString() {
		return (position.getPositionInitials() + "+" + bonus);
	}
}