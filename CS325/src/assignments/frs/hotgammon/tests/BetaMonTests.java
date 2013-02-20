package assignments.frs.hotgammon.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.movevalidators.CompleteMoveValidator;
import assignments.frs.hotgammon.turndeterminers.AlternatingTurnDeterminer;
import assignments.frs.hotgammon.winnerdeterminers.SixMoveWinnerDeterminer;

public class BetaMonTests {
	Game game;
	@Before
	public void setup(){
		game=new GameImpl(new CompleteMoveValidator(),new SixMoveWinnerDeterminer(), new AlternatingTurnDeterminer());
		game.newGame();
	}
	@Test
	public void shouldOnlyBeAbleToMoveInCorrectDirection(){
		game.nextTurn();
		assertFalse(game.move(Location.B6,Location.B7));
		assertTrue(game.move(Location.B6,Location.B5));
		game.nextTurn();
		assertFalse(game.move(Location.R6,Location.R7));
		assertTrue(game.move(Location.R6, Location.R3));
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
	@Test
	public void shouldRemoveToBar(){
		game.nextTurn();
		game.move(Location.R1, Location.R2);
		game.move(Location.R1, Location.R3);
		game.nextTurn();
		assertTrue(game.move(Location.R6, Location.R3));
		assertTrue(game.getCount(Location.R3)==1);
		assertTrue(game.getColor(Location.R3)==Color.RED);
		assertTrue(game.getCount(Location.B_BAR)==1);
		assertTrue(game.getColor(Location.B_BAR)==Color.BLACK);
	}
	@Test
	public void shouldNotBeAbleToMoveToBlockedSpot(){
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertFalse(game.move(Location.R1, Location.R6));
		assertTrue(game.getCount(Location.R6)==5);
		assertTrue(game.getColor(Location.R6)==Color.RED);
		assertTrue(game.getCount(Location.R1)==2);
		assertTrue(game.getColor(Location.R1)==Color.BLACK);
	}
	@Test
	public void shouldBeOnlyAbleToMoveBarPiece(){
		game.nextTurn();
		game.move(Location.R1, Location.R3);
		game.nextTurn();
		game.move(Location.R6, Location.R3);
		game.nextTurn();
		assertFalse(game.move(Location.B8, Location.B2));
		assertTrue(game.move(Location.B_BAR,Location.R5));
	}
	@Test
	public void shouldBeAbleToBearOffOnlyWhenAllPiecesInOppositeTable(){
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertFalse(game.move(Location.B6,Location.B_BEAR_OFF));
	}
}