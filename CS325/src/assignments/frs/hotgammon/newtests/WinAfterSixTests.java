package assignments.frs.hotgammon.newtests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.HotGammonFactory;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.variants.factories.AlphaMon;
import assignments.frs.hotgammon.variants.factories.BetaMon;
import assignments.frs.hotgammon.variants.factories.DeltaMon;


@RunWith(value = Parameterized.class)
public class WinAfterSixTests {
	private GameImpl game;
	
	public WinAfterSixTests(HotGammonFactory factory) {
		game = new GameImpl(factory);
		game.newGame();		
	}
	 @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] { {new AlphaMon()},
			                              {new BetaMon()},
			                              {new DeltaMon()},
	   };
	   return Arrays.asList(data);
	 }

	@Before
	public void setup() { 
		game.newGame();
	}

	@Test
	public void shouldBeRedWinnerAfterSixTurns() {
		System.out.println("In alphamon tests");
		for (int i = 0; i < 6; i++) {
			game.nextTurn();
		}
		assertTrue(game.winner() == Color.RED);
	}

	@Test
	public void shouldBeNoWinnerAfterFourTurns() {
		for (int i = 0; i < 4; i++) {
			game.nextTurn();
		}
		assertTrue(game.winner() == Color.NONE);
	}
	
	@Test
	public void shouldEndGameAfterSixTurns() {
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertEquals("Winner should be Red", Color.RED, game.winner());

	}

	@Test
	public void shouldNotEndGameAfterFiveTurns() {
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertEquals("Winner should be null", Color.NONE, game.winner());

	}

	@Test
	public void shouldHaveRedIsWinner() {
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertEquals("Winner should be Red", Color.RED, game.winner());

	}
	
	@Test
	public void shouldEndGameAfter6Rolls() {

		game.nextTurn();

		game.nextTurn();

		assertEquals("should not be a winner ", Color.NONE, game.winner());

		game.nextTurn();

		game.nextTurn();

		game.nextTurn();

		game.nextTurn();

		assertEquals("should not be a winner ", Color.RED, game.winner());

	}

	@Test
	public void shouldEndGameAfter5Rolls() {

		game.nextTurn();

		assertEquals("should not be a winner ", Color.NONE, game.winner());

		game.nextTurn();

		game.nextTurn();

		game.nextTurn();

		assertEquals("should not be a winner ", Color.NONE, game.winner());

	}
	

	@Test
	public void redWinsAfter6Turns() {
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertTrue(game.winner() == Color.NONE);
		game.nextTurn();
		assertEquals(game.winner(),Color.RED);
	}

}
