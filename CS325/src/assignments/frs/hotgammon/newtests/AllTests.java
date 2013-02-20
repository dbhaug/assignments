package assignments.frs.hotgammon.newtests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import assignments.frs.hotgammon.newtests.CoreTests;


@RunWith(Suite.class)
@SuiteClasses({CoreTests.class,  AlternatingTurnTests.class, WinAfterSixTests.class, BetaMonTests.class, GammaMonTests.class, DeltaMonTests.class, LocationTests.class } )
public class AllTests {
}
