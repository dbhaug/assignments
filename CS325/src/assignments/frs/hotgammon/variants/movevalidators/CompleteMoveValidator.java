package assignments.frs.hotgammon.variants.movevalidators;

import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.Location;

public class CompleteMoveValidator implements MoveValidator {
	private Game game;
	@Override
	public boolean isValid(Location from, Location to) {
		if(game.getPlayerInTurn()==Color.NONE&&(from==Location.R_BEAR_OFF||from==Location.B_BEAR_OFF)){
			return true;
		}
		if(!isCorrectDirection(from, to)){
			return false;
		}
		if(!hasDiceRollLeftForMove(from,to)){
			return false;
		}
		if(to==Location.R_BEAR_OFF||to==Location.B_BEAR_OFF){
			if(!checkForStrayPiecesNotInInnerTable(game.getPlayerInTurn())){
				return false;
			}
		}
		if(occupiedByOpponent(to)){
			return false;
		}
		if(!isTherePieceAt(from)){
			return false;
		}
		if(!correctCheckerForPlayerInTurn(from)){
			return false;
		}
		if(anyBarPieces()&&from!=(game.getPlayerInTurn()==Color.BLACK?Location.B_BAR:Location.R_BAR)){
			return false;
		}
		if(!makeSureMovesLeft()){
			return false;
		}
		System.out.println("good");
		return true;
	}
	private boolean isCorrectDirection(Location from, Location to){
		if(game.getPlayerInTurn()==Color.BLACK&&Location.distance(from, to)<0){
			return false;
		}else if(game.getPlayerInTurn()==Color.RED&&Location.distance(from, to)>0){
			return false;
		}
		return true;
	}
	private boolean occupiedByOpponent(Location loc){
		if(game.getColor(loc).getSign()==-game.getPlayerInTurn().getSign()&&game.getCount(loc)>1){
			return true;
		}
		return false;
	}
	private boolean barAble(Location loc){
		if(game.getColor(loc).getSign()==-game.getPlayerInTurn().getSign()&&game.getCount(loc)>0){
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
	private boolean hasDiceRollLeftForMove(Location from,Location to){
		Location.distance(from, to);
		for(int i:game.diceValuesLeft()){
			if(Math.abs(Location.distance(from, to))==i){
				return true;
			}
		}
		
		return false;
	}
	private boolean checkForStrayPiecesNotInInnerTable(Color player){
		for(int i=18;i>6;i--){
			if(game.getCount(Location.values()[i])>0&&game.getColor(Location.values()[i])==player){
				return false;
			}
		}
		for(int i=player==Color.BLACK?18:7;i==(player==Color.BLACK?0:24);i++){
			if(game.getCount(Location.values()[i])>0&&game.getColor(Location.values()[i])==player){
				return false;
			}
		}
		return true;
	}
	private boolean anyBarPieces(){
		if(game.getCount(game.getPlayerInTurn()==Color.BLACK?Location.B_BAR:Location.R_BAR)>0){
			return true;
		}
		return false;
	}
	
	private boolean makeSureMovesLeft(){
		if(game.getNumberOfMovesLeft()<=0){
			return false;
		}
		return true;
	}
	
	@Override
	public void setGame(Game game) {
		this.game=game;
	}

}
