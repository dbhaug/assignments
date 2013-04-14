package assignments.frs.hotgammon.variants.movevalidators;

import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.Location;

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
