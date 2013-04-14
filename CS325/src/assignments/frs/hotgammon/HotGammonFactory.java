package assignments.frs.hotgammon;

import assignments.frs.hotgammon.framework.Game;

public interface HotGammonFactory {
	public MoveValidator getMoveValidator();
	public TurnDeterminer getTurnDeterminer();
	public WinnerDeterminer getWinnerDeterminer();
	public RollDeterminer getRollDeterminer();
	public void setGame(Game game);
}
