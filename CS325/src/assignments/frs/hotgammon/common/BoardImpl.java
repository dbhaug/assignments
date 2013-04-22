package assignments.frs.hotgammon.common;

import assignments.frs.hotgammon.Board;
import assignments.frs.hotgammon.Triangle;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Location;

public class BoardImpl implements Board {
	private Triangle[] board;
	
	public BoardImpl(){
		board=new Triangle[29];
		for(int i=0;i<board.length;i++){
			board[i]=new Triangle();
		}
	}
	@Override
	public void put(Color player, Location loc) {
		board[loc.ordinal()].setColor(player);
		board[loc.ordinal()].setCount(board[loc.ordinal()].getCount()+1);
	}

	@Override
	public void put(Color player, Location loc, int amount) {
		board[loc.ordinal()].setColor(player);
		board[loc.ordinal()].setCount(board[loc.ordinal()].getCount()+amount);
	}

	@Override
	public Color getColorAt(Location loc) {
		return board[loc.ordinal()].getColor();
	}

	@Override
	public int getCountAt(Location loc) {
		return board[loc.ordinal()].getCount();
	}

	@Override
	public void remove(Color player, Location loc) {
		if(board[loc.ordinal()].getCount()<=1){
			board[loc.ordinal()].setCount(0);
			board[loc.ordinal()].setColor(Color.NONE);
			return;
		}
		board[loc.ordinal()].setCount(board[loc.ordinal()].getCount()-1);
	}

	@Override
	public void remove(Color player, Location loc, int amount) {
		if(board[loc.ordinal()].getCount()<=amount){
			board[loc.ordinal()].setCount(0);
			board[loc.ordinal()].setColor(Color.NONE);
			return;
		}
		board[loc.ordinal()].setCount(board[loc.ordinal()].getCount()-amount);
		
	}
	@Override
	public void clear() {
		for (int i=0;i<board.length;i++){
			board[i].setCount(0);
			board[i].setColor(Color.NONE);
		}
	}
	@Override
	public void setColor(Color player, Location loc) {
		if(board[loc.ordinal()].getCount()==0){
			return;
		}else if(board[loc.ordinal()].getColor()!=Color.NONE){
			return;
		}else{
			board[loc.ordinal()].setColor(player);
		}
	}

}
