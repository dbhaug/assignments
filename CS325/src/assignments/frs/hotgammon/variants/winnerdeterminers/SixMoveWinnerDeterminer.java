package assignments.frs.hotgammon.variants.winnerdeterminers;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.WinnerDeterminer;

public class SixMoveWinnerDeterminer implements WinnerDeterminer {
	Game game;
	int turns;
	@Override
	public Color getWinner() {
		return turns>=6?game.getPlayerInTurn():Color.NONE;
	}

	@Override
	public void setGame(Game game) {
		this.game=game;

	}
	@Override
	public void incrementTurn() {
		turns++;
	}

}
