package assignments.farmer.farmers;

import assignments.farmer.Farmer;
import assignments.farmer.Season;

public class Organic implements Farmer{
	
	private Season season;

	public Organic(Season season){
		this.season=season;
	}

	@Override
	public void plow() {
		if(season==Season.SPRING){
			System.out.println("plow under green manure");
		}
		else if(season==Season.SUMMER){
			System.out.println("plow fallow fields to prepare for fall cover");
		}else{
			System.out.println("no action");
		}
	}

	@Override
	public void plant() {
		if(season==Season.SPRING){
			System.out.println("peas, lettuce");
		}
		else if(season==Season.SUMMER){
			System.out.println("beans, squash, tomatoes, carrots, melons, 2nd round of peas and leafy greens");
		}else{
			System.out.println("late beans, squash, potatoes, leafy greens");
		}
	}

	@Override
	public void weedControl() {
		if(season==Season.SPRING){
			System.out.println("employ lots of interns with hoes");
		}
		else if(season==Season.SUMMER){
			System.out.println("employ lots of interns with hoes");
		}else{
			System.out.println("no action");
		}
	}

	@Override
	public void harvest() {
		if(season==Season.SPRING){
			System.out.println("employ lots of interns and volunteers");
		}
		else if(season==Season.SUMMER){
			System.out.println("employ lots of interns and volunteers");
		}else{
			System.out.println("employ lots of interns and volunteers; u-pick for squash");
		}
	}

	@Override
	public void market() {
		if(season==Season.SPRING){
			System.out.println("fall garlic, peas & lettuce to farmer's market");
		}
		else if(season==Season.SUMMER){
			System.out.println("peas, carrots, early beans, roma tomatoes to farmer's market");
		}else{
			System.out.println("beans, squash, tomatoes to farmer's market; big harvest party on farm");
		}
	}
}
