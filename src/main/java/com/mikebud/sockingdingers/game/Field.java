package com.mikebud.sockingdingers.game;

import java.io.Serializable;

import com.mikebud.sockingdingers.consts.Bases;
import com.mikebud.sockingdingers.consts.BasesOnHit;
import com.mikebud.sockingdingers.player.Player;

public class Field implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 497144774172091570L;

	private int runs;
	private Base[] basesState;

	public Field() {

		runs = 0;
		basesState = new Base[5];

		for (int i = 0; i < 5; i++) {
			basesState[i] = new Base();
		}

	}

	public int hit( Player p, BasesOnHit outcome ) {
		if( outcome == BasesOnHit.NO_ATBAT ) {
			System.err.println("hit during illegal at-bat");
			return 0;
		}
		
		if(outcome.getValue() >= 1) {
			getFieldStatus();
			System.out.println(p.name + " hits a " + outcome.toString());
		}
		
		int basesEarned = outcome.getValue();
		runs = 0;

		basesState[Bases.BOX.val].player = p;
		basesState[Bases.BOX.val].setOccupied(true);

		// On any hit all baserunners advance one base. Except for walks
		// and outs.
		if( outcome != BasesOnHit.WALK ) {

			if (basesEarned > 0) {
				basesState[Bases.HOME.val].movePlayer(basesState[Bases.THIRD.val]);
				basesState[Bases.THIRD.val].movePlayer(basesState[Bases.SECOND.val]);
				basesState[Bases.SECOND.val].movePlayer(basesState[Bases.FIRST.val]);
				basesState[Bases.FIRST.val].clearBase();
			} else {
				System.err.println("Not a hit. Shouldn't be here.");
			}
		}
		for (int i = 1; i <= basesEarned; i++) {

			if (basesState[Bases.FIRST.val].isOccupied() != true) {
				basesState[Bases.FIRST.val].movePlayer(basesState[Bases.BOX.val]);
			} else if (basesState[Bases.SECOND.val].isOccupied() != true) {
				basesState[Bases.SECOND.val].movePlayer(basesState[Bases.FIRST.val]);
				basesState[Bases.FIRST.val].movePlayer(basesState[Bases.BOX.val]);
			} else if (basesState[Bases.THIRD.val].isOccupied() != true) {
				basesState[Bases.THIRD.val].movePlayer(basesState[Bases.SECOND.val]);
				basesState[Bases.SECOND.val].movePlayer(basesState[Bases.FIRST.val]);
				basesState[Bases.FIRST.val].movePlayer(basesState[Bases.BOX.val]);
			} else if (basesState[Bases.HOME.val].isOccupied() != true) {
				basesState[Bases.HOME.val].movePlayer(basesState[Bases.THIRD.val]);
				basesState[Bases.THIRD.val].movePlayer(basesState[Bases.SECOND.val]);
				basesState[Bases.SECOND.val].movePlayer(basesState[Bases.FIRST.val]);
				basesState[Bases.FIRST.val].movePlayer(basesState[Bases.BOX.val]);
			}

			if (basesState[Bases.HOME.val].isOccupied() == true) {
				runs++;

				basesState[Bases.HOME.val].clearBase();
				System.out.println("Run Scores!!");
			}

		}

		for (int j = 0; j < basesEarned; j++) {
			basesState[j].clearBase();
		}

		//getFieldStatus();
		return runs;
	}

	public void resetField() {
		for (int i = 0; i <= Bases.HOME.val; i++) {
			basesState[i].clearBase();
		}
	}

	public void getFieldStatus() {

		for (Bases basesIdx : Bases.values()) {
			String output = basesIdx.name + " is "
					+ (basesState[basesIdx.val].player != null ? " occupied" : " not occupied")
					+ (basesState[basesIdx.val].player != null ? " by " + basesState[basesIdx.val].getPlayer().name : "");
			System.out.println( output );
		}
	}

	public int getRuns() {
		return runs;
	}

	public Base[] getBasesState() {
		return basesState;
	}

	public class Base {

		private Player player;
		//public final Player ghostPlayer;

		private boolean occupied;

		public Base() {
			player = null;
			occupied = false;
		}


		public Player getPlayer() {
			return player;
		}

		public void setPlayer(Player player) {
			this.player = player;
		}

		public boolean isOccupied() {
			return occupied;
		}


		public void setOccupied(boolean occupied) {
			this.occupied = occupied;
		}
		
		public void clearBase() {
			this.player = null;
			this.occupied = false;
		}

		/*
		 * I was struggling with doing element = element.
		 * It was somehow passing by reference.
		 * this faux copy constructor did the trick.
		 */
		public void movePlayer( Base baseIn ) {
			if(baseIn.occupied == true ) {
				this.player = baseIn.getPlayer();
				this.occupied = true;

				baseIn.setPlayer(null);
				//baseIn.occupied = false;
			} else {
				//do nothing.
			}
		}
	}
}