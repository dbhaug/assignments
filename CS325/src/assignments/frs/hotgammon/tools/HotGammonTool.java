package assignments.frs.hotgammon.tools;

import java.awt.event.MouseEvent;

import assignments.frs.hotgammon.framework.Game;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.Tool;
import minidraw.standard.AbstractTool;
import minidraw.standard.NullTool;

public class HotGammonTool extends AbstractTool {

	private Figure figure;
	private Tool fChild;
	private Game game;
	private Tool nullTool;

	public HotGammonTool(DrawingEditor editor, Game game) {
		super(editor);
		this.game=game;
		nullTool=new NullTool();
		fChild=nullTool;
	}
	
	@Override
	public void mouseDown(MouseEvent e, int x, int y) {
		Drawing model = editor().drawing();

	    model.lock();
		figure = model.findFigure(e.getX(), e.getY());
		if(figure!=null){
			if(game.getNumberOfMovesLeft()>0){
				fChild=new CheckerMoveTool(editor, game,figure);
			}
			else {
				fChild=new DieRollTool(editor, game);
			}
		}
		fChild.mouseDown(e, x, y);
	}
	@Override
	public void mouseDrag(MouseEvent e,int x, int y){
		fChild.mouseDrag(e, x, y);
	}
	
	@Override
	public void mouseMove(MouseEvent e,int x, int y){
		fChild.mouseMove(e, x, y);
	}
	
	@Override
	public void mouseUp(MouseEvent e,int x, int y){
		editor().drawing().unlock();
		fChild.mouseUp(e, x, y);
		fChild=nullTool;
	}
}
