package assignments.frs.hotgammon.tools;

import java.awt.Point;
import java.awt.event.MouseEvent;

import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.Location;
import assignments.frs.hotgammon.view.Convert;
import assignments.frs.hotgammon.view.DieFigure;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.Tool;
import minidraw.standard.AbstractTool;

public class CheckerMoveTool extends AbstractTool {
	
	protected Figure figure;
	protected Tool fChild;
	private int fLastX;
	private int fLastY;
	private Location fLastLoc;
	private Game game;
	private Point origin;

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
			origin=new Point(figure.displayBox().x, figure.displayBox().y);
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
		if(figure!=null){
			Location newLoc=Convert.xy2Location(x, y);
		
		if(game.move(fLastLoc, newLoc)){
			int c = game.getCount(newLoc);
			Point to_point=Convert.locationAndCount2xy(newLoc, game.getCount(newLoc)-1);
			figure.moveBy(to_point.x-figure.displayBox().x,to_point.y-figure.displayBox().y);
		}else {
			figure.moveBy(origin.x-figure.displayBox().x,origin.y-figure.displayBox().y);
		}
		editor().drawing().unlock();
		}
	}
}
