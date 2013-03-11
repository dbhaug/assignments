package assignments.frs.hotgammon.variants.movevalidators;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.MoveValidator;

public class SwitchingMoveValidator implements MoveValidator {
	Game game;
	MoveValidator beta;
	MoveValidator alpha;
	
	public SwitchingMoveValidator(){
		beta=new CompleteMoveValidator();
		alpha=new SimpleMoveValidator();
	}
	@Override
	public boolean isValid(Location from, Location to) {
		if(game.getPlayerInTurn()==Color.BLACK){
			return alpha.isValid(from, to);
		}
		else{
			return beta.isValid(from, to);
		}
	}

	@Override
	public void setGame(Game game) {
		this.game=game;
		beta.setGame(game);
		alpha.setGame(game);
	}

}
