package assignments.frs.hotgammon.variants.winnerdeterminers;

import assignments.frs.hotgammon.WinnerDeterminer;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;

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
	public void setTurns(int turns) {
		this.turns=turns;
	}

}
