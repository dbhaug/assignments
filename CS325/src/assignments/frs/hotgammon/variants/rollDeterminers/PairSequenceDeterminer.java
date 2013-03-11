package assignments.frs.hotgammon.variants.rollDeterminers;

import assignments.frs.hotgammon.RollDeterminer;

public class PairSequenceDeterminer implements RollDeterminer {
	private int turns;

	@Override
	public int[] getDiceThrown() {
		if(turns%3==1){
			return new int[] {1,2};
		}else if(turns%3==2){
			return new int[] {3,4};
		}else{
			return new int[] {5,6};
		}
	}

	@Override
	public void setTurns(int turns) {
		this.turns=turns;
	}
}
