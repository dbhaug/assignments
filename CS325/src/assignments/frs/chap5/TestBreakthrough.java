package assignments.frs.chap5;

import org.junit.*;
import static org.junit.Assert.*;

/** Initial test case class for Breakthrough

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
public class TestBreakthrough {
	Breakthrough game;
	/** Fixture */
	@Before
	public void setUp() {
		game = new BreakthroughImpl();
	}

	@Test
	public void shouldHaveBlackPawnOn00(){
		assertEquals( "Black has pawn on (0,0)",
				BreakthroughImpl.PieceType.BLACK, game.getPieceAt(0,0) );
	}
	@Test
	public void shouldHaveWhitePawnOn77(){
		assertEquals( "White has pawn on (7,7)",
				BreakthroughImpl.PieceType.WHITE, game.getPieceAt(7,7) );
	}
	@Test
	public void firstPlayerShouldBeBlack(){
		assertEquals( "Black goes first",
				BreakthroughImpl.PlayerType.BLACK, game.getPlayerInTurn() );
	}@Test
	public void shouldBeAbleToMove(){
		assertTrue("Black moves down",game.isMoveValid(1,0,2,0));
		assertTrue("White moves up",game.isMoveValid(6,0,5,0));
	}
	@Test
	public void shouldNotBeAbleToMove(){
		assertFalse(game.isMoveValid(0,0,1,0));
		assertFalse(game.isMoveValid(1,2,0,2));
		assertFalse(game.isMoveValid(7,7,8,8));
	}
}
