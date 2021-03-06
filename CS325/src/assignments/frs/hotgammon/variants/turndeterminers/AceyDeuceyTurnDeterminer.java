package assignments.frs.hotgammon.variants.turndeterminers;

import assignments.frs.hotgammon.TurnDeterminer;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;

public class AceyDeuceyTurnDeterminer implements TurnDeterminer {
	private Game game;
	@Override
	public Color getNextPlayerInTurn(Color currentPlayer) {
		if(currentPlayer==Color.NONE){
			return currentPlayer==Color.BLACK?Color.RED:Color.BLACK;
		}
		boolean one=false;
		boolean two=false;
		for(int i=0;i<game.diceThrown().length;i++){
			if(game.diceThrown()[i]==1){
				one=true;
			}
			if(game.diceThrown()[i]==2){
				two=true;
			}
		}
		if(one&&two){
			return game.getPlayerInTurn();
		}
		return currentPlayer==Color.BLACK?Color.RED:Color.BLACK;
	}

	@Override
	public void setGame(Game game) {
		this.game=game;
	}
}
