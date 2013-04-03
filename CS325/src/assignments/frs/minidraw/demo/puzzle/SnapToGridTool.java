package assignments.frs.minidraw.demo.puzzle;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.RubberBandSelectionStrategy;
import minidraw.standard.SelectionTool;

public class SnapToGridTool extends SelectionTool {

	public SnapToGridTool(DrawingEditor editor,
			RubberBandSelectionStrategy selectionStrategy) {
		super(editor, selectionStrategy);
	}
	public SnapToGridTool(DrawingEditor editor){
		super(editor);
	}
	@Override
	public void mouseUp(MouseEvent e, int x, int y) {
		Rectangle box;
		for ( Figure f : editor().drawing().selection() ) {
			box=f.displayBox();
			System.out.println(box.x);
			System.out.println(box.y);
			f.moveBy(findClosestSnapPoint(box.x,675)-box.x,
					 findClosestSnapPoint(box.y,675)-box.y);
			System.out.println(box.x);
			System.out.println(box.y);
		    }
		editor().drawing().unlock();
	    fChild = cachedNullTool;
	    draggedFigure = null;
	}
	private int findClosestSnapPoint(int var, int totalSize){
		int x=0;
		if(Math.abs(var-0)>Math.abs(var-totalSize/3)){
			x=totalSize/3;
		}
		int one=var-totalSize/3;
		int temp=totalSize*2/3;
		int two=var-totalSize*2/3;
		if(Math.abs(one)>Math.abs(two)){
			x=totalSize*2/3;
		}
		return x;
	}
}
