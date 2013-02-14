package assignments.frs.hotgammon.variants;

import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.MoveValidator;

public class BetaMoveValidator implements MoveValidator {
	private Game game;
	@Override
	public boolean isValid(Location from, Location to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setGame(Game game) {
		this.game=game;
	}

}
