package assignments.frs.hotgammon.variants.rollDeterminers;

import assignments.frs.hotgammon.RollDeterminer;

public class BlotTestRollDeterminer implements RollDeterminer {

	@Override
	public int[] getDiceThrown() {
		return new int[]{1,1};
	}

	@Override
	public void setTurns(int turns) {
		// TODO Auto-generated method stub
		
	}

}
