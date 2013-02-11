package assignments.frs.hotgammon.alphamon;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.Triangle;

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
	private Triangle[] board;
	private int numberOfMoves;
	private int turns;
	private AlphaMoveValidator validator;
	
	public GameImpl(){
		validator=new AlphaMoveValidator(this);
	}
	
	public void newGame() {
		turns=0;
		playerInTurn=Color.NONE;
		board=new Triangle[28];
		for(int i=0;i<28;i++){
			board[i]=new Triangle();
		}
		board[Location.R1.ordinal()].setCount(2);
		board[Location.R1.ordinal()].setColor(Color.BLACK);
		board[Location.B1.ordinal()].setColor(Color.RED);
		board[Location.B1.ordinal()].setCount(2);
		board[Location.R1.ordinal()].setCount(2);
		board[Location.B6.ordinal()].setCount(5);
		board[Location.B6.ordinal()].setColor(Color.BLACK);
		board[Location.R6.ordinal()].setCount(5);
		board[Location.R6.ordinal()].setColor(Color.RED);
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
		if(board[from.ordinal()].getCount()<1){
			return false;
		}
		if(!makeSureMovesLeft()){
			return false;
		}
		board[from.ordinal()].setCount(board[from.ordinal()].getCount()-1);
		board[to.ordinal()].setCount(board[to.ordinal()].getCount()+1);
		if(board[to.ordinal()].getColor()==Color.NONE){
			board[to.ordinal()].setColor(playerInTurn);
		}
		if(board[from.ordinal()].getCount()<1){
			board[from.ordinal()].setColor(Color.NONE);
		}
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
		return board[location.ordinal()].getColor();
	}
	public int getCount(Location location) {
		return board[location.ordinal()].getCount();
	}
	private boolean makeSureMovesLeft(){
		if(numberOfMoves<=0){
			return false;
		}
		return true;
	}
}
