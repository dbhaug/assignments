package assignments.frs.chap5;

/** Implementation stub.

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
public class BreakthroughImpl implements Breakthrough {
	
	private int[][] board;
	private int boardSize=8;
	private PlayerType playerInTurn=PlayerType.WHITE;
	
	public BreakthroughImpl(){
		board=new int[boardSize][boardSize];
		for(int i=0;i<boardSize;i++){
			for(int j=0;j<boardSize;j++){
				if(i<2){
					board[i][j]=1;
				}else if(i>5){
					board[i][j]=2;
				}else{
					board[i][j]=0;
				}
			}
		}
	}
	
	public PieceType getPieceAt( int row, int column ) {
		int piece=board[row][column];
		if(piece==1){
			return PieceType.BLACK;
		}else if(piece==2){
			return PieceType.WHITE;
		}
		return PieceType.NONE;
	}

	public PlayerType getPlayerInTurn() {
		return playerInTurn;
	}

	public PlayerType getWinner() {
		for(int i=0;i<boardSize;i++){
			if(getPieceAt(0,i)==PieceType.WHITE){
				return PlayerType.WHITE;
			}else if(getPieceAt(boardSize-1,i)==PieceType.BLACK){
				return PlayerType.BLACK;
			}
		}
		return null;
	}

	public boolean isMoveValid(int fromRow, int fromColumn,
			int toRow, int toColumn) {
		if(!testForBoardLimits(fromRow,fromColumn,toRow,toColumn)){
			return false;
		}
		if(!testForMovementDirection(fromRow,fromColumn,toRow,toColumn)){
			return false;
		}
		if(!testForMovingOwnPiece(fromRow,fromColumn,toRow,toColumn)){
			return false;
		}
		if(!testForDistance(fromRow,fromColumn,toRow,toColumn)){
			return false;
		}
		if(!testForStraightPieceTake(fromRow,fromColumn,toRow,toColumn)){
			return false;
		}
		return true;
		
	}
	public void move(int fromRow, int fromColumn,
			int toRow, int toColumn) {
		if(isMoveValid(fromRow,fromColumn,toRow,toColumn)){
			board[toRow][toColumn]=board[fromRow][fromColumn];
			board[fromRow][fromColumn]=0;
			playerInTurn=playerInTurn==PlayerType.BLACK?PlayerType.WHITE:PlayerType.BLACK;
		}
		if(getWinner()!=null){
			
		}
	}
	private boolean testForBoardLimits(int fromRow,int fromColumn,int toRow,int toColumn){
		if(toColumn>boardSize-1||toRow>boardSize-1){
			return false;
		}
		if(toColumn<0||toRow<0){
			return false;
		}
		return true;
	}
	private boolean testForMovingOwnPiece(int fromRow,int fromColumn,int toRow,int toColumn){
		if(playerInTurn==PlayerType.WHITE&&getPieceAt(fromRow, fromColumn)!=PieceType.WHITE){
			return false;
		}
		if(playerInTurn==PlayerType.BLACK&&getPieceAt(fromRow, fromColumn)!=PieceType.BLACK){
			return false;
		}
		return true;
	}
	private boolean testForMovementDirection(int fromRow,int fromColumn,int toRow,int toColumn){
		if(playerInTurn==PlayerType.BLACK&&toRow<fromRow){
			return false;
		}
		if(playerInTurn==PlayerType.WHITE&&toRow>fromRow){
			return false;
		}
		return true;
	}
	private boolean testForDistance(int fromRow,int fromColumn,int toRow,int toColumn){
		if(Math.abs(fromRow-toRow)>1){
			return false;
		}
		if(Math.abs(fromColumn-toColumn)>1){
			return false;
		}
		return true;
	}
	private boolean testForStraightPieceTake(int fromRow,int fromColumn,int toRow,int toColumn){
		if(toColumn==fromColumn){
			return board[toRow][toColumn]==0;
		}
		return true;
	}
	
}

