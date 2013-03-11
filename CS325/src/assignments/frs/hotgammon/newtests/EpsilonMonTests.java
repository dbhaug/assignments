package assignments.frs.hotgammon.newtests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import assignments.frs.hotgammon.common.GameImpl;
import assignments.frs.hotgammon.variants.factories.EpsilonMon;

public class EpsilonMonTests {
	private GameImpl game;
	
	@Before
	public void setup(){
		this.game=new GameImpl(new EpsilonMon());
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
