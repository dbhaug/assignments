package assignments.frs.hotgammon.variants.factories;

import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.HotGammonFactory;
import assignments.frs.hotgammon.MoveValidator;
import assignments.frs.hotgammon.RollDeterminer;
import assignments.frs.hotgammon.TurnDeterminer;
import assignments.frs.hotgammon.WinnerDeterminer;
import assignments.frs.hotgammon.variants.movevalidators.SimpleMoveValidator;
import assignments.frs.hotgammon.variants.rollDeterminers.PairSequenceDeterminer;
import assignments.frs.hotgammon.variants.turndeterminers.AceyDeuceyTurnDeterminer;
import assignments.frs.hotgammon.variants.winnerdeterminers.SixMoveWinnerDeterminer;

public class DeltaMon implements HotGammonFactory {

	private MoveValidator mValidator;
	private TurnDeterminer tDeterminer;
	private WinnerDeterminer wDeterminer;
	private RollDeterminer rDeterminer;
	
	public DeltaMon(){
		mValidator=new SimpleMoveValidator();
		tDeterminer=new AceyDeuceyTurnDeterminer();
		wDeterminer=new SixMoveWinnerDeterminer();
		rDeterminer=new PairSequenceDeterminer();
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