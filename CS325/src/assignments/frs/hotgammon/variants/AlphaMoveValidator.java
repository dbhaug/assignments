package assignments.frs.hotgammon.variants;

import assignments.frs.hotgammon.*;

public class AlphaMoveValidator implements MoveValidator {
	private Game game;
	@Override
	public boolean isValid(Location from, Location to) {
		if(occupiedByOpponent(to)){
			return false;
		}
		
		if(!correctCheckerForPlayerInTurn(from)){
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
	public void setGame(Game game){
		this.game=game;
	}
}
