package assignments.frs.hotgammon.alphamon;

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
	private Color playerInTurn=Color.NONE;
	private Triangle[] board;
	private int numberOfMoves;
	

	public void newGame() {
		board=new Triangle[28];
		board[Location.R1.ordinal()].setCount(2);
	}
	public void nextTurn() {
		playerInTurn=Color.BLACK;
		numberOfMoves = 2;
	}
	public boolean move(Location from, Location to) {
		if(board[to.ordinal()].getColor().getSign()==-playerInTurn.getSign()){
			return false;
		}
		board[from.ordinal()].setCount(board[from.ordinal()].getCount()-1);
		board[to.ordinal()].setCount(board[to.ordinal()].getCount()+1);
		numberOfMoves--;
		return true;
	}
	public Color getPlayerInTurn() { return playerInTurn; }
	public int getNumberOfMovesLeft() {
		return numberOfMoves;
	}
	public int[] diceThrown() { return new int[] {1,1}; }
	public int[] diceValuesLeft() { return new int []{}; }
	public Color winner() { return Color.NONE; }
	public Color getColor(Location location) {
		return board[location.ordinal()].getColor();
	}
	public int getCount(Location location) {
		return board[location.ordinal()].getCount();
	}
}
