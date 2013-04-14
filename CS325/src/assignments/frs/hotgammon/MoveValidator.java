package assignments.frs.hotgammon;

import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.Location;

public interface MoveValidator {
	public boolean isValid(Location from,Location to);
	public void setGame(Game game);
}
