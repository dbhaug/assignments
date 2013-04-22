package assignments.frs.hotgammon.variants.rollDeterminers;

import java.util.Random;
import assignments.frs.hotgammon.RollDeterminer;

public class RandomRollDeterminer implements RollDeterminer {

	@Override
	public int[] getDiceThrown() {
		Random diceRoller=new Random();	
		int[] temp={diceRoller.nextInt(6)+1,diceRoller.nextInt(6)+1};
		return temp;
	}

	@Override
	public void setTurns(int turns) {
		
	}

}
