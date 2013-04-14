package assignments.frs.hotgammon;

import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;

public interface TurnDeterminer {
	public Color getNextPlayerInTurn(Color currentPlayer);
	public void setGame(Game game);
}
