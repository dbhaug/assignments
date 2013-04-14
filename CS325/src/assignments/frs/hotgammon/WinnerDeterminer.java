package assignments.frs.hotgammon;

import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;

public interface WinnerDeterminer {
	public Color getWinner();
	public void setGame(Game game);
	public void setTurns(int turns);
}
