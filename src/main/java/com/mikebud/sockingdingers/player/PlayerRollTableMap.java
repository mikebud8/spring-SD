package com.mikebud.sockingdingers.player;

import java.util.TreeMap;

import com.mikebud.sockingdingers.consts.BasesOnHit;

public class PlayerRollTableMap extends TreeMap<Integer, BasesOnHit> {
	public RollStat popOut = new RollStat();
	public RollStat strikeOut = new RollStat();
	public RollStat groundOut = new RollStat();
	public RollStat flyOut = new RollStat();
	public RollStat walk = new RollStat();
	public RollStat single = new RollStat();
	public RollStat singlePlus = new RollStat();
	public RollStat twoBagger = new RollStat();
	public RollStat triple = new RollStat();
	public RollStat dinger = new RollStat();
	
	public PlayerRollTableMap() {

	}
	
	public void setStats() {
	//Nobody's perfect
	//Returns a mapping associated with the greatest key less than or equal to the given key, or null if there is no such key.
	this.clear();
	this.put(popOut.min, BasesOnHit.POPOUT);
	this.put(strikeOut.min, BasesOnHit.STRIKEOUT);
	this.put(groundOut.min, BasesOnHit.GROUNDOUT);
	this.put(flyOut.min, BasesOnHit.FLYOUT);
	this.put(walk.min, BasesOnHit.WALK);
	this.put(single.min, BasesOnHit.SINGLE);
	this.put(singlePlus.min, BasesOnHit.SINGLEPLUS);
	this.put(twoBagger.min, BasesOnHit.TWOBAGGER);
	this.put(triple.min, BasesOnHit.TRIPLE);
	this.put(dinger.min, BasesOnHit.DINGER);

	}
	
	public class RollStat {
		public int min;
		public int max;
		
		public RollStat() {
			min = -1;
			max = -1;
		}
		
		public RollStat(int minIn, int maxIn) {
			min = minIn;
			max = maxIn;
		}
	}
}

