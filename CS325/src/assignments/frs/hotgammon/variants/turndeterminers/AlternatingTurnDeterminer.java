package assignments.frs.hotgammon.variants.turndeterminers;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.TurnDeterminer;

public class AlternatingTurnDeterminer implements TurnDeterminer{
	@Override
	public Color getNextPlayerInTurn(Color currentPlayer) {
		return currentPlayer==Color.BLACK?Color.RED:Color.BLACK;
	}

	@Override
	public void setGame(Game game) {
		// TODO Auto-generated method stub
		
	}

}