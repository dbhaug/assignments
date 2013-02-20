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
import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.TurnDeterminer;
import assignments.frs.hotgammon.WinnerDeterminer;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.variants.movevalidators.SimpleMoveValidator;
import assignments.frs.hotgammon.variants.movevalidators.CompleteMoveValidator;
import assignments.frs.hotgammon.variants.turndeterminers.AceyDeuceyTurnDeterminer;
import assignments.frs.hotgammon.variants.turndeterminers.AlternatingTurnDeterminer;
import assignments.frs.hotgammon.variants.winnerdeterminers.SixMoveWinnerDeterminer;

@RunWith(value = Parameterized.class)
public class WinAfterSixTests {
	private GameImpl game;
	
	public WinAfterSixTests(MoveValidator validator, WinnerDeterminer winnerDeterminer, TurnDeterminer ntd) {
		game = new GameImpl(validator, winnerDeterminer, ntd);
		game.newGame();		
	}
	 @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] { { new SimpleMoveValidator(), new SixMoveWinnerDeterminer(), new AlternatingTurnDeterminer() },
			                              { new CompleteMoveValidator(), new SixMoveWinnerDeterminer() , new AlternatingTurnDeterminer()},
			                              { new SimpleMoveValidator(), new SixMoveWinnerDeterminer() , new AceyDeuceyTurnDeterminer()},
	   };
	   return Arrays.asList(data);
	 }

	@Before
	public void setup() { 
		game = new GameImpl(new CompleteMoveValidator(), new SixMoveWinnerDeterminer(), new AlternatingTurnDeterminer());
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
		assertTrue(game.winner() == Color.RED);
	}

}
