package assignments.frs.hotgammon;

public interface WinnerDeterminer {
	public Color getWinner();
	public void setGame(Game game);
	public void incrementTurn();
}
