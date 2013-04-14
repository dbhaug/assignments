package assignments.frs.hotgammon.variants.winnerdeterminers;

import assignments.frs.hotgammon.WinnerDeterminer;
import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.Location;

public class BearOffWinnerDeterminer implements WinnerDeterminer {
	private Game game;
	@Override
	public Color getWinner() {
		if(game.getPlayerInTurn()==Color.NONE){
			return Color.NONE;
		}
		if(game.getCount(game.getPlayerInTurn()==Color.BLACK?Location.B_BEAR_OFF:Location.R_BEAR_OFF)==15){
			return game.getPlayerInTurn();
		}
		
		return Color.NONE;
	}

	@Override
	public void setGame(Game game) {
		this.game=game;

	}

	@Override
	public void setTurns(int turns) {
		// TODO Auto-generated method stub
		
	}

}
