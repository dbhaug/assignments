package assignments.frs.hotgammon.variants.factories;

import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.HotGammonFactory;
import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.RollDeterminer;
import assignments.frs.hotgammon.TurnDeterminer;
import assignments.frs.hotgammon.WinnerDeterminer;
import assignments.frs.hotgammon.variants.movevalidators.CompleteMoveValidator;
import assignments.frs.hotgammon.variants.rollDeterminers.RandomRollDeterminer;
import assignments.frs.hotgammon.variants.turndeterminers.AlternatingTurnDeterminer;
import assignments.frs.hotgammon.variants.winnerdeterminers.BearOffWinnerDeterminer;

public class SemiMon implements HotGammonFactory {
	private MoveValidator mValidator;
	private TurnDeterminer tDeterminer;
	private WinnerDeterminer wDeterminer;
	private RollDeterminer rDeterminer;
	
	public SemiMon(){
		mValidator=new CompleteMoveValidator();
		tDeterminer=new AlternatingTurnDeterminer();
		wDeterminer=new BearOffWinnerDeterminer();
		rDeterminer=new RandomRollDeterminer();
	}

	@Override
	public MoveValidator getMoveValidator() {
		return mValidator;
	}

	@Override
	public TurnDeterminer getTurnDeterminer() {
		return tDeterminer;
	}

	@Override
	public WinnerDeterminer getWinnerDeterminer() {
		return wDeterminer;
	}

	@Override
	public RollDeterminer getRollDeterminer() {
		return rDeterminer;
	}

	@Override
	public void setGame(Game game) {
		wDeterminer.setGame(game);
		tDeterminer.setGame(game);
		mValidator.setGame(game);
	}
}
