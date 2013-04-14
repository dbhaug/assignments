package assignments.frs.hotgammon;

import assignments.frs.hotgammon.framework.Color;


public class Triangle {
	private int count=0;
	private Color color=Color.NONE;
	
	public int getCount(){
		return count;
	}
	public Color getColor(){
		return color;
	}
	public void setCount(int newCount){
		count=newCount;
	}
	public void setColor(Color newColor){
		color=newColor;
	}
}

