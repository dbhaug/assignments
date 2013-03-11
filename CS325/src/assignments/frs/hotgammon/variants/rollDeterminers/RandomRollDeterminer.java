package assignments.frs.hotgammon.variants.rollDeterminers;

import java.util.Random;
import assignments.frs.hotgammon.RollDeterminer;

public class RandomRollDeterminer implements RollDeterminer {

	@Override
	public int[] getDiceThrown() {
		Random diceRoller=new Random(6);
		return new int[]{diceRoller.nextInt()+1,diceRoller.nextInt()+1};
	}

	@Override
	public void setTurns(int turns) {
	}

}
