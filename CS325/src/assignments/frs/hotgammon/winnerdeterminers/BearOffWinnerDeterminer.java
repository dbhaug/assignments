package assignments.frs.hotgammon.winnerdeterminers;

import assignments.frs.hotgammon.Color;
import assignments.frs.hotgammon.Game;
import assignments.frs.hotgammon.Location;
import assignments.frs.hotgammon.WinnerDeterminer;

public class BearOffWinnerDeterminer implements WinnerDeterminer {
	private Game game;
	@Override
	public Color getWinner() {
		if(game.getPlayerInTurn()==Color.NONE){
			return Color.NONE;
		}
		for(int i=0;i<26;i++){
			if(i<13){
				if(game.getColor(Location.findLocation(Color.BLACK, Location.B_BAR, i))==game.getPlayerInTurn()){
					return Color.NONE;
				}
			}
		}
		
		return game.getPlayerInTurn();
	}

	@Override
	public void setGame(Game game) {
		this.game=game;

	}

	@Override
	public void incrementTurn() {
		// TODO Auto-generated method stub
		
	}

}
