package assignments.frs.hotgammon.tools;

import java.awt.Point;
import java.awt.event.MouseEvent;

import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.GameObserver;
import assignments.frs.hotgammon.framework.Location;
import assignments.frs.hotgammon.view.Convert;
import assignments.frs.hotgammon.view.DieFigure;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.Tool;
import minidraw.standard.AbstractTool;
import minidraw.standard.ImageFigure;
import minidraw.standard.handlers.DragTracker;

public class CheckerMoveTool extends AbstractTool {
	
	protected Figure figure;
	protected Tool fChild;
	private int fLastX;
	private int fLastY;
	private Location fLastLoc;
	private Game game;

	public CheckerMoveTool(DrawingEditor editor, Game game, Figure figure) {
		super(editor);
		this.game=game;
		this.figure=figure;
	}
	
	@Override
	public void mouseDown(MouseEvent e, int x, int y) {
		Drawing model = editor().drawing();
		if(figure instanceof DieFigure){
			model.clearSelection();
			figure=null;
		}
		
		
		if(figure !=null){
			if ( e.isShiftDown() ) {
				model.toggleSelection(figure);
			} else if ( ! model.selection().contains(figure) ) {
				model.clearSelection();
				model.addToSelection(figure);
			}
			fLastLoc=Convert.xy2Location(x, y);
			fLastX = x; fLastY = y; 
		}
		
	}

	@Override
	public void mouseDrag(MouseEvent e, int x, int y) {
	    for ( Figure f : editor().drawing().selection() ) {
	    	f.moveBy( x - fLastX, y - fLastY );
		}
		fLastX = x;
		fLastY = y; 
	}
	@Override
	public void mouseUp(MouseEvent e, int x, int y) {
		Location newLoc=Convert.xy2Location(x, y);
		Point point=Convert.locationAndCount2xy(newLoc, game.getCount(newLoc));
		if(game.move(fLastLoc, newLoc)){
			for (Figure f :editor().drawing().selection()){
				f.moveBy(point.x-f.displayBox().x,point.y-f.displayBox().y);
			}
		}else {
			Point oldPoint=Convert.locationAndCount2xy(fLastLoc, game.getCount(fLastLoc)-1);
			for (Figure f :editor().drawing().selection()){
				f.moveBy(oldPoint.x-f.displayBox().x,oldPoint.y-f.displayBox().y);
			}
		}
		editor().drawing().clearSelection();
		editor().drawing().unlock();
	}
}
