package assignments.frs.hotgammon.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.variants.movevalidators.SimpleMoveValidator;
import assignments.frs.hotgammon.variants.turndeterminers.AceyDeuceyTurnDeterminer;
import assignments.frs.hotgammon.variants.winnerdeterminers.BearOffWinnerDeterminer;

public class DeltaMonTests {
	Game game;
	
	@Before
	public void setup(){
		game=new GameImpl(new SimpleMoveValidator(),new BearOffWinnerDeterminer(),new AceyDeuceyTurnDeterminer());
		game.newGame();
	}
	@Test
	public void shouldBeExtraTurn() {
		game.nextTurn();
		assertTrue(game.getPlayerInTurn()==Color.BLACK);
		assertArrayEquals(new int[]{1,2},game.diceThrown());
		game.nextTurn();
		assertTrue(game.getPlayerInTurn()==Color.BLACK);
	}
	@Test
	public void shouldNotBeExtraTurn(){
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertTrue(game.getPlayerInTurn()==Color.RED);
	}

}
