package assignments.frs.hotgammon.common;

import java.util.ArrayList;

import assignments.frs.hotgammon.Board;
import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.TurnDeterminer;
import assignments.frs.hotgammon.WinnerDeterminer;

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
	private WinnerDeterminer winValidator;
	private TurnDeterminer turnValidator;
	private ArrayList<Integer> diceValuesLeft;
	
	public GameImpl(MoveValidator validator,WinnerDeterminer winValidator, TurnDeterminer turnValidator){
		this.validator=validator;
		this.validator.setGame(this);
		this.winValidator=winValidator;
		this.winValidator.setGame(this);
		this.turnValidator=turnValidator;
		this.turnValidator.setGame(this);
	}
	public void newGame() {
		turns=0;
		playerInTurn=Color.NONE;
		board=new BoardImpl();
		board.put(Color.BLACK,Location.R1,2);
		board.put(Color.RED,Location.R8,3);
		board.put(Color.BLACK,Location.R12,5);
		board.put(Color.RED,Location.B12,5);
		board.put(Color.BLACK,Location.B8,3);
		board.put(Color.RED, Location.B1,2);
		board.put(Color.BLACK, Location.B6,5);
		board.put(Color.RED, Location.R6,5);
	}
	public void nextTurn() {
		playerInTurn=turnValidator.getNextPlayerInTurn(playerInTurn);
		numberOfMoves = 2;
		turns++;
		winValidator.incrementTurn();
		diceValuesLeft=new ArrayList();
		diceValuesLeft.add(new Integer(diceThrown()[0]));
		diceValuesLeft.add(new Integer(diceThrown()[1]));
	}
	static public class Placement {
        public Location location;
        public Color    player;
        public Placement(Color player, Location location) {
            this.player = player;
            this.location = location;
        }
    }
	public boolean move(Location from, Location to) {
		if(!validator.isValid(from, to)){
			return false;
		}
		if(!makeSureMovesLeft()){
			return false;
		}
		for(int i:diceValuesLeft){
			if(Math.abs(Location.distance(from, to))==i){
				diceValuesLeft.remove(new Integer(i));
				break;
			}
		}
		if(getColor(to).getSign()==-getPlayerInTurn().getSign()&&getCount(to)<2){
			board.put(getColor(to), playerInTurn==Color.BLACK?Location.R_BAR:Location.B_BAR);
			board.remove(getColor(to), to);
			board.put(playerInTurn, to);
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
	public int[] diceValuesLeft() {
		int[] ret = new int[diceValuesLeft.size()];
	    for (int i=0; i < ret.length; i++){
	        ret[i] = diceValuesLeft.get(i).intValue();
	    }
	    return ret;
	}
	public Color winner() {
		return winValidator.getWinner();
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
	public void configure(Placement[] placements) {
		board.clear();
		if (placements==null||placements.length==0){
			return;
		}
        for (int i = 0; i < placements.length; i++) {
            board.put(placements[i].player, placements[i].location);
        }
    }
}