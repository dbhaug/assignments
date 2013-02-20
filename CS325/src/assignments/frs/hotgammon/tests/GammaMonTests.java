package assignments.frs.hotgammon.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.movevalidators.SimpleMoveValidator;
import assignments.frs.hotgammon.turndeterminers.AlternatingTurnDeterminer;
import assignments.frs.hotgammon.winnerdeterminers.BearOffWinnerDeterminer;

public class GammaMonTests {
	Game game;
	
	@Before
	public void setup(){
		game=new GameImpl(new SimpleMoveValidator(),new BearOffWinnerDeterminer(), new AlternatingTurnDeterminer());
		game.newGame();
	}
	@Test
	public void shouldNotBeAWinnerRightAway() {
		assertTrue(game.winner()==Color.NONE);
		game.nextTurn();
		assertTrue(game.winner()==Color.NONE);
	}
	@Test
	public void shouldNotEndAfter6Turns(){
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertEquals(game.winner(),Color.NONE);
	}
}
