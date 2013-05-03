package assignments.frs.hotgammon.variants.factories;

import assignments.frs.hotgammon.HotGammonFactory;
import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.RollDeterminer;
import assignments.frs.hotgammon.TurnDeterminer;
import assignments.frs.hotgammon.WinnerDeterminer;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.variants.movevalidators.CompleteMoveValidator;
import assignments.frs.hotgammon.variants.rollDeterminers.BlotTestRollDeterminer;
import assignments.frs.hotgammon.variants.rollDeterminers.RandomRollDeterminer;
import assignments.frs.hotgammon.variants.turndeterminers.AlternatingTurnDeterminer;
import assignments.frs.hotgammon.variants.winnerdeterminers.BearOffWinnerDeterminer;

public class BlotTestMon implements HotGammonFactory {

	private Game game;

	@Override
	public MoveValidator getMoveValidator() {
		MoveValidator mValidator=new CompleteMoveValidator();
		mValidator.setGame(game);
		return mValidator;
		
	}

	@Override
	public TurnDeterminer getTurnDeterminer() {
		TurnDeterminer tDeterminer=new AlternatingTurnDeterminer();
		tDeterminer.setGame(game);
		return tDeterminer;
	}

	@Override
	public WinnerDeterminer getWinnerDeterminer() {
		WinnerDeterminer wDeterminer=new BearOffWinnerDeterminer();
		wDeterminer.setGame(game);
		return wDeterminer;
	}

	@Override
	public RollDeterminer getRollDeterminer() {
		RollDeterminer rDeterminer=new BlotTestRollDeterminer();
		return rDeterminer;
	}

	@Override
	public void setGame(Game game) {
		this.game=game;
	}
}
