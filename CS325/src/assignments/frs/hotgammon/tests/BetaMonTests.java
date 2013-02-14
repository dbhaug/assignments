package assignments.frs.hotgammon.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.variants.BetaMoveValidator;

public class BetaMonTests {
	Game game;
	@Before
	public void setup(){
		game=new GameImpl(new BetaMoveValidator());
		game.newGame();
	}
	@Test
	public void shouldOnlyBeAbleToMoveInCorrectDirection(){
		game.nextTurn();
		assertFalse(game.move(Location.B6,Location.B7));
		assertTrue(game.move(Location.B6,Location.B5));
		game.nextTurn();
		assertFalse(game.move(Location.R6,Location.R7));
		assertTrue(game.move(Location.R6, Location.R5));
	}
	@Test
	public void shouldCorrespondToDiceRolls(){
		game.nextTurn();
		game.move(Location.R1, Location.R2);
		assertTrue(game.diceValuesLeft()[0]==2);
		assertFalse(game.move(Location.R1, Location.R2));
		assertTrue(game.move(Location.R1, Location.R3));
		game.nextTurn();
		game.move(Location.B1, Location.B4);
		assertTrue(game.diceValuesLeft()[0]==4);
		assertFalse(game.move(Location.B1, Location.B4));
		assertTrue(game.move(Location.B1, Location.B5));
	}

}
