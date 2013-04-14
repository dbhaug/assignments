package assignments.frs.hotgammon.newtests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.variants.factories.GammaMon;
import assignments.frs.hotgammon.variants.movevalidators.SimpleMoveValidator;
import assignments.frs.hotgammon.variants.rollDeterminers.PairSequenceDeterminer;
import assignments.frs.hotgammon.variants.turndeterminers.AlternatingTurnDeterminer;
import assignments.frs.hotgammon.variants.winnerdeterminers.BearOffWinnerDeterminer;
import assignments.frs.hotgammon.common.GameImpl.Placement;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Location;

public class GammaMonTests {

	private GameImpl game;

	@Before
	public void setup() {
		game = new GameImpl(new GammaMon());
		game.newGame();
	}

	@Test
	public void shouldBeWinForBlack() {
		game.configure(new Placement[] {

		new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF)

		});
		game.nextTurn();
		assertEquals(Color.BLACK, game.winner());
	}

	@Test
	public void shouldBeNoWinner() {
		game.configure(new Placement[] {

		new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF),
				new Placement(Color.BLACK, Location.B_BEAR_OFF)

		});
		game.nextTurn();
		assertEquals(Color.NONE, game.winner());
	}

	@Test
	public void shouldBeWinForRed() {
		game.configure(new Placement[] {
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF),
				new Placement(Color.RED, Location.R_BEAR_OFF) });

		game.nextTurn();
		game.nextTurn();
		assertEquals(Color.RED, game.winner());
	}
}
