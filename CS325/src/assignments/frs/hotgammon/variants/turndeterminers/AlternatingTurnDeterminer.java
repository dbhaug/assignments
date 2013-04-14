package assignments.frs.hotgammon.variants.turndeterminers;

import assignments.frs.hotgammon.TurnDeterminer;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;

public class AlternatingTurnDeterminer implements TurnDeterminer{
	Game game;
	@Override
	public Color getNextPlayerInTurn(Color currentPlayer) {
		return currentPlayer==Color.BLACK?Color.RED:Color.BLACK;
	}

	@Override
	public void setGame(Game game) {
		this.game=game;		
	}

}
