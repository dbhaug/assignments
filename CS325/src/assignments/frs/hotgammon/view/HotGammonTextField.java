package assignments.frs.hotgammon.view;

import javax.swing.JTextField;

import assignments.frs.hotgammon.framework.GameObserver;
import assignments.frs.hotgammon.framework.Location;

public class HotGammonTextField extends JTextField implements GameObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotGammonTextField(String string) {
		this.setText(string);
	}

	@Override
	public void checkerMove(Location from, Location to) {
		return;
	}

	@Override
	public void diceRolled(int[] values) {
		return;
	}

	@Override
	public void statusUpdate(String message) {
		this.setText(message);
	}

}
