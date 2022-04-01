package com.mikebud.sockingdingers.player;

import java.util.TreeMap;

import com.mikebud.sockingdingers.consts.BasesOnHit;

//We aren't going over the wire with this.
@SuppressWarnings("serial")
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

	@Override
	public String toString() {
		String lastString = "";
		if(dinger.min == 20) {
			lastString = "+";
		} else {
			lastString = ("-" + dinger.max);
		}
		return 
				"PO = " + popOut.min + "-" + popOut.max + "\n" +
				"SO = " + strikeOut.min + "-" + strikeOut.max + "\n" +
				"GO = " + groundOut.min + "-" + groundOut.max + "\n" +
				"FO = " + flyOut.min + "-" + flyOut.max + "\n" +
				"W = " + walk.min + "-" + walk.max + "\n" +
				"S = " + single.min + "-" + single.max + "\n" +
				"S+ = " + singlePlus.min + "-" + singlePlus.max + "\n" +
				"2B = " + twoBagger.min + "-" + twoBagger.max + "\n" +
				"3B = " + triple.min + "-" + triple.max + "\n" +
				"HR = " + dinger.min + lastString + "\n"
				;

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

