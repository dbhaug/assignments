package assignments.frs.hotgammon.turndeterminers;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.TurnDeterminer;

public class AceyDeuceyTurnDeterminer implements TurnDeterminer {
	private Game game;
	@Override
	public Color getNextPlayerInTurn(Color currentPlayer) {
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
