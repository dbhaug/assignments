package assignments.frs.hotgammon.alphamon;

import org.junit.*;
import static org.junit.Assert.*;

/** Testing skeleton for AlphaMon.

   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University

   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
 */
public class AlphaMonTest {
	private Game game;

	@Before public void setup() {
		game = new GameImpl();
		game.newGame();
	}

	@Test 
	public void shouldHaveNoPlayerInTurnAfterNewGame() {
		assertEquals( Color.NONE, game.getPlayerInTurn() );
	}
	@Test 
	public void shouldHaveBlackPlayerInTurnAfterNextTurn() {
		game.nextTurn();
		assertEquals( Color.BLACK, game.getPlayerInTurn() );
	}
	@Test
	public void shouldHaveTwoBlackCheckersOnR1(){
		game.nextTurn();
		assertTrue(game.getCount(Location.R1)==2);
		assertTrue(game.getColor(Location.R1)==Color.BLACK);
	}
	@Test
	public void shouldBeAbleToMoveBlackR1toR2(){
		game.nextTurn();
		assertTrue(game.move(Location.R1, Location.R2));
		assertTrue(game.getCount(Location.R1)==1);
		assertTrue(game.getCount(Location.R2)==1);
		assertTrue(game.getNumberOfMovesLeft()==1);
		
	}
	@Test
	public void shouldNotBeAbleToMoveBlackR1toB1(){
		game.nextTurn();
		assertFalse(game.move(Location.R1, Location.B1));
	}
	@Test
	public void shouldHaveNoMoveLeft(){
		game.nextTurn();
		game.move(Location.R1, Location.R2);
		game.move(Location.R1, Location.R3);
		assertTrue(game.getNumberOfMovesLeft()==0);
	}
	@Test
	public void redShouldBeInTurn(){
		game.nextTurn();
		game.move(Location.R1, Location.R2);
		game.move(Location.R1, Location.R3);
		game.nextTurn();
		assertTrue(game.getPlayerInTurn()==Color.RED);
	}
	@Test
	public void diceRollsShouldBeIncremental(){
		game.nextTurn();
		assertArrayEquals(game.diceThrown(),new int[] {1,2});
		game.move(Location.R1, Location.R2);
		game.move(Location.R1, Location.R3);
		game.nextTurn();
		assertArrayEquals(game.diceThrown(),new int[] {3,4});
		game.nextTurn();
		assertArrayEquals(game.diceThrown(),new int[] {5,6});
		game.nextTurn();
		assertArrayEquals(game.diceThrown(),new int[] {1,2});
		game.nextTurn();
		assertArrayEquals(game.diceThrown(),new int[] {3,4});
		game.nextTurn();
		assertArrayEquals(game.diceThrown(),new int[] {5,6});
	}
	@Test
	public void shouldNotBeAbleToMoveWithNoMovesLeft(){
		game.nextTurn();
		game.move(Location.R1, Location.R2);
		game.move(Location.R1, Location.R3);
		assertFalse(game.move(Location.R2, Location.R3));
	}
	@Test
	public void redShouldBeWinnerAfter6Turns(){
		game.nextTurn();
		assertTrue(game.winner()==Color.NONE);
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		game.nextTurn();
		assertTrue(game.winner()==Color.RED);
	}
	@Test
	public void redShouldBeAbleToMove(){
		game.nextTurn();
		assertTrue(game.move(Location.B1, Location.B2));
	}
	@Test
	public void shouldNotBeAbleToMoveFromASpotWithoutCheckers(){
		game.nextTurn();
		assertFalse(game.move(Location.R2, Location.R3));
	}
}
