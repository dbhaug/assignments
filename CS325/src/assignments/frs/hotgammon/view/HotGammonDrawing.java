package assignments.frs.hotgammon.view;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import assignments.frs.hotgammon.framework.Color;
import assignments.frs.hotgammon.framework.Game;
import assignments.frs.hotgammon.framework.GameObserver;
import assignments.frs.hotgammon.framework.Location;
import minidraw.framework.Figure;
import minidraw.standard.StandardDrawing;

public class HotGammonDrawing extends StandardDrawing implements GameObserver{

	private Game game;

	public HotGammonDrawing(Game game) {
		this.game=game;
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

	@Override
	public void statusUpdate(String message) {
		return;
	}
}
