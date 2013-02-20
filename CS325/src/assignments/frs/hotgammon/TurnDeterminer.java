package assignments.frs.hotgammon;

public interface TurnDeterminer {
	public Color getNextPlayerInTurn(Color currentPlayer);
	public void setGame(Game game);
}
