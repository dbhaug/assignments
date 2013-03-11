package assignments.frs.hotgammon.newtests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.variants.factories.HandicapFactory;

public class HandicapTests {
	private GameImpl game;

	@Before
	public void setup() { 
		game = new GameImpl(new HandicapFactory());
		game.newGame();
	}

	@Test
	public void moveDistanceShouldEqualRoll() {
		game.nextTurn();
		game.nextTurn();
		int[] roll = game.diceValuesLeft();
		assertTrue(roll.length ==2);
		Location to = Location.findLocation(game.getPlayerInTurn(), Location.B1, roll[0]);
		assertTrue(game.move(Location.B1, to));
	}
	@Test
	public void diceRollDoesntMatter() {
		game.nextTurn();
		assertTrue(game.diceValuesLeft()[0]==1&&game.diceValuesLeft()[1]==2);
		assertTrue(game.move(Location.R1, Location.R4));
	}

}
