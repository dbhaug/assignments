package assignments.frs.hotgammon.common;

import java.util.ArrayList;

import assignments.frs.hotgammon.Board;
import assignments.frs.hotgammon.HotGammonFactory;
import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.RollDeterminer;
import assignments.frs.hotgammon.TurnDeterminer;
import assignments.frs.hotgammon.WinnerDeterminer;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.GameObserver;
import assignments.frs.hotgammon.framework.Location;

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
	private int[] diceValues;
	private ArrayList<GameObserver> gameObservers;
	
	public GameImpl(HotGammonFactory factory){
		setup(factory);
	}
	public void newGame() {
		turns=0;
		playerInTurn=Color.NONE;
		board=new BoardImpl();
		board.put(Color.BLACK, Location.R_BEAR_OFF,15);
		board.put(Color.RED, Location.B_BEAR_OFF,15);
	 	move(Location.R_BEAR_OFF,Location.R1);
		move(Location.R_BEAR_OFF,Location.R1);
		move(Location.R_BEAR_OFF,Location.R12);
		move(Location.R_BEAR_OFF,Location.R12);
		move(Location.R_BEAR_OFF,Location.R12);
		move(Location.R_BEAR_OFF,Location.R12);
		move(Location.R_BEAR_OFF,Location.R12);
		move(Location.R_BEAR_OFF,Location.B8);
		move(Location.R_BEAR_OFF,Location.B8);
		move(Location.R_BEAR_OFF,Location.B8);
		move(Location.R_BEAR_OFF,Location.B6);
		move(Location.R_BEAR_OFF,Location.B6);
		move(Location.R_BEAR_OFF,Location.B6);
		move(Location.R_BEAR_OFF,Location.B6);
		move(Location.R_BEAR_OFF,Location.B6);
		board.setColor(Color.BLACK, Location.R1);
		board.setColor(Color.BLACK, Location.R12);
		board.setColor(Color.BLACK, Location.B8);
		board.setColor(Color.BLACK, Location.B6);
		move(Location.B_BEAR_OFF,Location.R8);
		move(Location.B_BEAR_OFF,Location.R8);
		move(Location.B_BEAR_OFF,Location.R8);
		move(Location.B_BEAR_OFF,Location.B12);
		move(Location.B_BEAR_OFF,Location.B12);
		move(Location.B_BEAR_OFF,Location.B12);
		move(Location.B_BEAR_OFF,Location.B12);
		move(Location.B_BEAR_OFF,Location.B12);
		move(Location.B_BEAR_OFF,Location.B1);
		move(Location.B_BEAR_OFF,Location.B1);
		move(Location.B_BEAR_OFF,Location.R6);
		move(Location.B_BEAR_OFF,Location.R6);
		move(Location.B_BEAR_OFF,Location.R6);
		move(Location.B_BEAR_OFF,Location.R6);
		move(Location.B_BEAR_OFF,Location.R6);
		board.setColor(Color.RED, Location.B1);
		board.setColor(Color.RED, Location.R8);
		board.setColor(Color.RED, Location.B12);
		board.setColor(Color.RED, Location.R6);
	}
	public void setup(HotGammonFactory factory) {
		this.factory=factory;
		this.factory.setGame(this);
		winDeterminer=factory.getWinnerDeterminer();
		turnDeterminer=factory.getTurnDeterminer();
		rollDeterminer=factory.getRollDeterminer();
		validator=factory.getMoveValidator();
		gameObservers=new ArrayList<GameObserver>();
	}
	public void nextTurn() {
		diceValues=null;
		playerInTurn=turnDeterminer.getNextPlayerInTurn(playerInTurn);
		numberOfMoves = 2;
		turns++;
		winDeterminer.setTurns(turns);
		rollDeterminer.setTurns(turns);
		diceValuesLeft=new ArrayList();
		diceValuesLeft.add(new Integer(diceThrown()[0]));
		diceValuesLeft.add(new Integer(diceThrown()[1]));
		
		if(diceThrown()[0]==diceThrown()[1]){
			diceValuesLeft.add(new Integer(diceThrown()[0]));
			diceValuesLeft.add(new Integer(diceThrown()[1]));
			numberOfMoves=4;
		}
		for(GameObserver g:gameObservers){
			g.diceRolled(diceThrown());
			g.statusUpdate("It is "+playerInTurn.toString()+"'s turn, "+getTurnStatusMessage());
		}
		
	}
	static public class Placement {
        public Location location;
        public Color    player;
        public Placement(Color player, Location location) {
            this.player = player;
            this.location = location;
        }
    }
	// 
	private boolean isBearOffMove(Location from) {
		return from == Location.B_BEAR_OFF || from == Location.R_BEAR_OFF;
		
	}
	
	private void consumeDie(Location from, Location to) {
		int length=diceValuesLeft.size();
		for(int i:diceValuesLeft){
			if(Math.abs(Location.distance(from, to))==i){
				diceValuesLeft.remove(new Integer(i));
				break;
			}
			
		}
		if(length==diceValuesLeft.size()){
			int distance=Math.abs(Location.distance(from, to));
			for(int i:diceValuesLeft){
				if(distance<i){
					diceValuesLeft.remove(new Integer(i));
					break;
				}
			}
		}
		numberOfMoves--;
	}
	
	private void notifyObserversOfMove(Location from, Location to) {
		for(GameObserver g:gameObservers){
			g.checkerMove(from,to);
		}
	}
	
	public boolean move(Location from, Location to) {
		if(board.getCountAt(playerInTurn==Color.BLACK?Location.B_BAR:Location.R_BAR)>0){
			if(!checkForValidBarMoves()){
				numberOfMoves=0;
				for(GameObserver g:gameObservers){
					g.statusUpdate("Stuck on the Bar!");
				}
				return false;
			}
		}
		if(!validator.isValid(from, to)){
			for(GameObserver g:gameObservers){
				g.statusUpdate("Incorrect Move! "+getTurnStatusMessage());
			}
			return false;
		}
		if(isBearOffMove(from)){
			
			board.remove(playerInTurn, from);
			board.put(playerInTurn, to);
			notifyObserversOfMove(from, to);
			return true;
		}
		consumeDie(from, to);
		String  msg = getTurnStatusMessage();
		
		if(getColor(to).getSign()==-getPlayerInTurn().getSign()&&getCount(to)<2&&playerInTurn!=Color.NONE){
			
			board.put(getColor(to), playerInTurn==Color.BLACK?Location.R_BAR:Location.B_BAR);
			board.remove(getColor(to), to);
			notifyObserversOfMove(to,playerInTurn==Color.BLACK?Location.R_BAR:Location.B_BAR );
			msg = "Blot! " + msg;
		}
		board.remove(playerInTurn, from);
		board.put(playerInTurn, to);
		
		for(GameObserver g:gameObservers){
			g.statusUpdate(msg);
		}

		return true;
	}
	
	public Color getPlayerInTurn() { return playerInTurn; }
	
	public int getNumberOfMovesLeft() {
		return numberOfMoves;
	}
	
	public int[] diceThrown() {
		if(diceValues==null){
			diceValues=rollDeterminer.getDiceThrown();
		}
		return diceValues;
		
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
	public void configure(Placement[] placements) {
		board.clear();
		if (placements==null||placements.length==0){
			return;
		}
        for (int i = 0; i < placements.length; i++) {
            board.put(placements[i].player, placements[i].location);
        }
    }
	@Override
	public void addObserver(GameObserver observer) {
		gameObservers.add(observer);
		
	}
	private String getTurnStatusMessage(){
		if(numberOfMoves==0){
			return "No moves left. Click a die to pass the turn";
		}else {
			String temp=playerInTurn.toString()+ " has "+ numberOfMoves+" moves left "+" Dice values ";
			for(int i:diceValuesLeft){
				temp+=i+" ";
			}
			return temp;
		}
	}
	private boolean checkForValidBarMoves(){
		for(int i:diceValuesLeft){
			Location temp=Location.findLocation(playerInTurn, playerInTurn==Color.BLACK?Location.B_BAR:Location.R_BAR, i);
			if(validator.isValid(playerInTurn==Color.BLACK?Location.B_BAR:Location.R_BAR, temp)){
				return true;
			}
		}
		return false;
	}
}