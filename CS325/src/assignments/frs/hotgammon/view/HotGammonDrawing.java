package assignments.frs.hotgammon.view;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.GameObserver;
import assignments.frs.hotgammon.framework.Location;

import minidraw.framework.DrawingChangeListener;
import minidraw.framework.Figure;
import minidraw.framework.FigureChangeEvent;
import minidraw.standard.StandardDrawing;

public class HotGammonDrawing extends StandardDrawing implements GameObserver{

	private Game game;

	public HotGammonDrawing(Game game) {
		this.game=game;
	}

	@Override
	public void addToSelection(Figure arg0) {
		// TODO Auto-generated method stub
		super.addToSelection(arg0);
	}

	@Override
	public void clearSelection() {
		// TODO Auto-generated method stub
		super.clearSelection();
	}

	@Override
	public void removeFromSelection(Figure arg0) {
		// TODO Auto-generated method stub
		super.removeFromSelection(arg0);
	}

	@Override
	public List<Figure> selection() {
		// TODO Auto-generated method stub
		return super.selection();
	}

	@Override
	public void toggleSelection(Figure arg0) {
		// TODO Auto-generated method stub
		super.toggleSelection(arg0);
	}

	@Override
	public void figureChanged(FigureChangeEvent arg0) {
		// TODO Auto-generated method stub
		super.figureChanged(arg0);
	}

	@Override
	public void figureInvalidated(FigureChangeEvent arg0) {
		// TODO Auto-generated method stub
		super.figureInvalidated(arg0);
	}

	@Override
	public void figureRemoved(FigureChangeEvent arg0) {
		// TODO Auto-generated method stub
		super.figureRemoved(arg0);
	}

	@Override
	public void figureRequestRemove(FigureChangeEvent arg0) {
		// TODO Auto-generated method stub
		super.figureRequestRemove(arg0);
	}

	@Override
	public void figureRequestUpdate(FigureChangeEvent arg0) {
		// TODO Auto-generated method stub
		super.figureRequestUpdate(arg0);
	}

	@Override
	public void addDrawingChangeListener(DrawingChangeListener arg0) {
		// TODO Auto-generated method stub
		super.addDrawingChangeListener(arg0);
	}

	@Override
	public void removeDrawingChangeListener(DrawingChangeListener arg0) {
		// TODO Auto-generated method stub
		super.removeDrawingChangeListener(arg0);
	}

	@Override
	public Figure findFigure(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return super.findFigure(arg0, arg1);
	}

	@Override
	public Iterator<Figure> iterator() {
		// TODO Auto-generated method stub
		return super.iterator();
	}
	
	@Override
	public Figure remove(Figure arg0) {
		// TODO Auto-generated method stub
		return super.remove(arg0);
	}
	
	@Override
	public Figure add(Figure arg0) {
		// TODO Auto-generated method stub
		return super.add(arg0);
	}

	@Override
	public void requestUpdate() {
		// TODO Auto-generated method stub
		super.requestUpdate();
	}
	
	@Override
	public void lock() {
		// TODO Auto-generated method stub
		super.lock();
	}
	
	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		super.unlock();
	}

	@Override
	public void checkerMove(Location from, Location to) {
		lock();
		if(from==Location.R_BEAR_OFF){
			addChecker(Color.BLACK,to);
		}else if(from==Location.B_BEAR_OFF){
			addChecker(Color.RED,to);
		}else if(to==Location.B_BAR||to==Location.R_BAR){
			Point oldPoint=Convert.locationAndCount2xy(from, 0);
			Point newPoint=Convert.locationAndCount2xy(to, game.getCount(to));
			Figure figure=findFigure(oldPoint.x,oldPoint.y);
			if(figure!=null){
				System.out.println("attempting a move to bar");
				figure.moveBy(newPoint.x-oldPoint.x,newPoint.y-oldPoint.y);
				oldPoint=Convert.locationAndCount2xy(from, 1);
				newPoint=Convert.locationAndCount2xy(from,0);
				System.out.println(oldPoint.x+" "+oldPoint.y);
				Iterator<Figure> it=iterator();
				while(it.hasNext()){
					Figure fig=it.next();
					System.out.println(fig.displayBox().x+", "+fig.displayBox().y);
				}
				figure=findFigure(oldPoint.x+1,oldPoint.y-1);
				
				if(figure!=null){
					System.out.println("attempting to move checker down");
					figure.moveBy(newPoint.x-oldPoint.x,newPoint.y-oldPoint.y);
				}
				
			}
		}
		unlock();
	}

	@Override
	public void diceRolled(int[] values) {
		lock();
		ArrayList<Point> points=new ArrayList<Point>();
		points.add(new Point(216,202));
		points.add(new Point(306,202));
		for(int i=0;i<points.size();i++){
			remove(findFigure(points.get(i).x,points.get(i).y));
			add(new DieFigure("die"+values[i],points.get(i)));
		}
		unlock();
	}
	private void addChecker(Color color, Location to){
		Point newPoint=Convert.locationAndCount2xy(to, game.getCount(to)-1);
		add(new CheckerFigure(color.toString().toLowerCase()+"checker",newPoint));
		System.out.println("Placed!");
	}

}
