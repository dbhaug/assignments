package assignments.frs.hotgammon;

import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Location;

public interface Board {
	public void put(Color player,Location loc);
	public void put(Color player,Location loc,int amount);
	public void remove(Color player,Location loc);
	public void remove(Color player,Location loc, int amount);
	public Color getColorAt(Location loc);
	public int getCountAt(Location loc);
	public void clear();
}