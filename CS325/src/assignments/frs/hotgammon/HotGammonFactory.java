package assignments.frs.hotgammon;

public interface HotGammonFactory {
	public MoveValidator getMoveValidator();
	public TurnDeterminer getTurnDeterminer();
	public WinnerDeterminer getWinnerDeterminer();
	public RollDeterminer getRollDeterminer();
	public void setGame(Game game);
}
