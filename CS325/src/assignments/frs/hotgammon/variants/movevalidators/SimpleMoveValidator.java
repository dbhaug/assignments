package assignments.frs.hotgammon.variants.movevalidators;

import assignments.frs.hotgammon.*;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.Location;

public class SimpleMoveValidator implements MoveValidator {
	private Game game;
	@Override
	public boolean isValid(Location from, Location to) {
		if(occupiedByOpponent(to)){
			return false;
		}if(!correctCheckerForPlayerInTurn(from)){
			return false;
		}if(!isTherePieceAt(from)){
			return false;
		}if(!makeSureMovesLeft()){
			return false;
		}
		return true;
	}
	private boolean occupiedByOpponent(Location loc){
		if(game.getColor(loc).getSign()==-game.getPlayerInTurn().getSign()){
			return true;
		}
		return false;
	}
	private boolean correctCheckerForPlayerInTurn(Location loc){
		return game.getColor(loc)==game.getPlayerInTurn();
	}
	private boolean isTherePieceAt(Location loc){
		if(game.getCount(loc)<1){
			return false;
		}
		return true;
	}
	private boolean makeSureMovesLeft(){
		if(game.getNumberOfMovesLeft()<=0){
			return false;
		}
		return true;
	}
	public void setGame(Game game){
		this.game=game;
	}
}