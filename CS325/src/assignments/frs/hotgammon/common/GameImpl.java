package assignments.frs.hotgammon.common;

import java.util.ArrayList;

import assignments.frs.hotgammon.Board;
import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.HotGammonFactory;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.RollDeterminer;
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
	private WinnerDeterminer winDeterminer;
	private TurnDeterminer turnDeterminer;
	private RollDeterminer rollDeterminer;
	private ArrayList<Integer> diceValuesLeft;
	private HotGammonFactory factory;
	
	public GameImpl(HotGammonFactory factory){
		this.factory=factory;
		this.factory.setGame(this);
		winDeterminer=factory.getWinnerDeterminer();
		turnDeterminer=factory.getTurnDeterminer();
		rollDeterminer=factory.getRollDeterminer();
		validator=factory.getMoveValidator();
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
		playerInTurn=turnDeterminer.getNextPlayerInTurn(playerInTurn);
		numberOfMoves = 2;
		turns++;
		winDeterminer.setTurns(turns);
		rollDeterminer.setTurns(turns);
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
		numberOfMoves--;
		if(getColor(to).getSign()==-getPlayerInTurn().getSign()&&getCount(to)<2){
			board.put(getColor(to), playerInTurn==Color.BLACK?Location.R_BAR:Location.B_BAR);
			board.remove(getColor(to), to);
			board.put(playerInTurn, to);
			
			return true;
		}
		board.remove(playerInTurn, from);
		board.put(playerInTurn, to);
		return true;
	}
	public Color getPlayerInTurn() { return playerInTurn; }
	public int getNumberOfMovesLeft() {
		return numberOfMoves;
	}
	public int[] diceThrown() { 
		return rollDeterminer.getDiceThrown();
	}
	public int[] diceValuesLeft() {
		int[] ret = new int[diceValuesLeft.size()];
	    for (int i=0; i < ret.length; i++){
	        ret[i] = diceValuesLeft.get(i).intValue();
	    }
	    return ret;
	}
	public Color winner() {
		return winDeterminer.getWinner();
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