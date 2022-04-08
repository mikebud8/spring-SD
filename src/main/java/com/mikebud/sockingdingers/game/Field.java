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

	int runs;
	Base[] field;

	public Field() {

		runs = 0;
		field = new Base[5];

		for (int i = 0; i < 5; i++) {
			field[i] = new Base();
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

		field[Bases.BOX.val].player = p;
		field[Bases.BOX.val].occupied = true;

		// On any hit all baserunners advance one base. Except for walks
		// and outs.
		if( outcome != BasesOnHit.WALK ) {

			if (basesEarned > 0) {
				field[Bases.HOME.val].movePlayer(field[Bases.THIRD.val]);
				field[Bases.THIRD.val].movePlayer(field[Bases.SECOND.val]);
				field[Bases.SECOND.val].movePlayer(field[Bases.FIRST.val]);
				field[Bases.FIRST.val].clearBase();
			} else {
				System.err.println("Not a hit. Shouldn't be here.");
			}
		}
		for (int i = 1; i <= basesEarned; i++) {

			if (field[Bases.FIRST.val].occupied != true) {
				field[Bases.FIRST.val].movePlayer(field[Bases.BOX.val]);
			} else if (field[Bases.SECOND.val].occupied != true) {
				field[Bases.SECOND.val].movePlayer(field[Bases.FIRST.val]);
				field[Bases.FIRST.val].movePlayer(field[Bases.BOX.val]);
			} else if (field[Bases.THIRD.val].occupied != true) {
				field[Bases.THIRD.val].movePlayer(field[Bases.SECOND.val]);
				field[Bases.SECOND.val].movePlayer(field[Bases.FIRST.val]);
				field[Bases.FIRST.val].movePlayer(field[Bases.BOX.val]);
			} else if (field[Bases.HOME.val].occupied != true) {
				field[Bases.HOME.val].movePlayer(field[Bases.THIRD.val]);
				field[Bases.THIRD.val].movePlayer(field[Bases.SECOND.val]);
				field[Bases.SECOND.val].movePlayer(field[Bases.FIRST.val]);
				field[Bases.FIRST.val].movePlayer(field[Bases.BOX.val]);
			}

			if (field[Bases.HOME.val].occupied == true) {
				runs++;

				field[Bases.HOME.val].clearBase();
				System.out.println("Run Scores!!");
			}

		}

		for (int j = 0; j < basesEarned; j++) {
			field[j].clearBase();
		}

		//getFieldStatus();
		return runs;
	}

	public void resetField() {
		for (int i = 0; i <= Bases.HOME.val; i++) {
			field[i].clearBase();
		}
	}

	public void getFieldStatus() {

		for (Bases basesIdx : Bases.values()) {
			String output = basesIdx.name + " is "
					+ (field[basesIdx.val].player != null ? " occupied" : " not occupied")
					+ (field[basesIdx.val].player != null ? " by " + field[basesIdx.val].getPlayer().name : "");
			System.out.println( output );
		}
	}

	public class Base {

		private Player player;
		//public final Player ghostPlayer;

		boolean occupied;

		public Base() {
			//ghostPlayer = new Player();
			//ghostPlayer.name ="GHOST";
			player = null;
			occupied = false;
		}


		public Player getPlayer() {
			return player;
		}

		public void setPlayer(Player player) {
			this.player = player;
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