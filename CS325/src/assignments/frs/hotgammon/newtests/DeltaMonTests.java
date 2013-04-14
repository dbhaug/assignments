package assignments.frs.hotgammon.newtests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.variants.factories.DeltaMon;


public class DeltaMonTests {

	private GameImpl game;

	@Before
	public void setup() { 
		game = new GameImpl(new DeltaMon());
		game.newGame();
	}
	
	@Test
	public void shouldGiveBlackConsectiveTurnsAfter12() {
		game.nextTurn();
		assertEquals(Color.BLACK, game.getPlayerInTurn());
		game.nextTurn();
		assertEquals(Color.BLACK,  game.getPlayerInTurn());
		game.nextTurn();
		assertEquals(Color.RED,  game.getPlayerInTurn());
	}

}
