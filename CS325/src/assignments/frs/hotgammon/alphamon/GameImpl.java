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
	private int[][] board;
	private int numberOfMoves;

	public void newGame() {
		board=new int[2][28];
		for(int i=0;i<board.length;i++){
			board[1][i]=0;
			board[0][i]=0;
		}
		board[1][0]=1;
		board[1][25]=-1;
		board[1][26]=1;
		board[1][27]=-1;
		board[0][1]=2;
		board[1][1]=1;
		board[0][24]=2;
		board[1][24]=-1;
	}
	public void nextTurn() {
		playerInTurn=Color.BLACK;
		numberOfMoves = 2;
	}
	public boolean move(Location from, Location to) {
		if(board[1][to.ordinal()]==-playerInTurn.getSign()){
			return false;
		}
		board[0][from.ordinal()]--;
		board[0][to.ordinal()]++;
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
		return Color.getColorFromNumerical(board[1][location.ordinal()]);
	}
	public int getCount(Location location) { 
		return board[0][location.ordinal()];
	}
}
