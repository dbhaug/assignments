package assignments.frs.hotgammon.tools;

import java.awt.event.MouseEvent;

import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.view.DieFigure;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.AbstractTool;

public class DieRollTool extends AbstractTool {

	private Game game;

	public DieRollTool(DrawingEditor editor, Game game) {
		super(editor);
		this.game=game;
	}
	public void mouseDown(MouseEvent e, int x,int y){
		Drawing model=editor().drawing();
		Figure figure=model.findFigure(e.getX(),e.getY());
		if(figure instanceof DieFigure){
			game.nextTurn();
		}
		model.clearSelection();
		figure=null;
	}
	public void mouseUp(MouseEvent e, int x, int y){
		editor().drawing().unlock();
	}
	public void mouseDrag(MouseEvent e, int x, int y){
		
	}
}
