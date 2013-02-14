package assignments.frs.hotgammon.common;

import assignments.frs.hotgammon.Board;
import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.MoveValidator;

/** Skeleton implementation of HotGammon.

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
public class GameImpl implements Game {
	private Color playerInTurn;
	private Board board;
	private int numberOfMoves;
	private int turns;
	private MoveValidator validator;
	
	public GameImpl(MoveValidator validator){
		this.validator=validator;
		validator.setGame(this);
	}
	
	public void newGame() {
		turns=0;
		playerInTurn=Color.NONE;
		board=new BoardImpl();
		board.put(Color.BLACK,Location.R1,2);
		board.put(Color.RED, Location.B1,2);
		board.put(Color.BLACK, Location.B6,5);
		board.put(Color.RED, Location.R6,5);
	}
	public void nextTurn() {
		playerInTurn=playerInTurn==Color.BLACK?Color.RED:Color.BLACK;
		numberOfMoves = 2;
		turns++;
	}
	public boolean move(Location from, Location to) {
		if(!validator.isValid(from, to)){
			return false;
		}
		if(board.getCountAt(from)<1){
			return false;
		}
		if(!makeSureMovesLeft()){
			return false;
		}
		board.remove(playerInTurn, from);
		board.put(playerInTurn, to);
		numberOfMoves--;
		return true;
	}
	public Color getPlayerInTurn() { return playerInTurn; }
	public int getNumberOfMovesLeft() {
		return numberOfMoves;
	}
	public int[] diceThrown() { 
		if(turns%3==1){
			return new int[] {1,2};
		}else if(turns%3==2){
			return new int[] {3,4};
		}else{
			return new int[] {5,6};
		}
	}
	public int[] diceValuesLeft() { return new int []{}; }
	public Color winner() {
		return turns>5?Color.RED:Color.NONE;
	}
	public Color getColor(Location location) {
		return board.getColorAt(location);
	}
	public int getCount(Location location) {
		return board.getCountAt(location);
	}
	private boolean makeSureMovesLeft(){
		if(numberOfMoves<=0){
			return false;
		}
		return true;
	}
}
