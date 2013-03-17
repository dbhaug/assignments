package assignments.farmer.farmers;

import assignments.farmer.Farmer;
import assignments.farmer.Season;

public class Amish implements Farmer {
	
	private Season season;

	public Amish(Season season){
		this.season=season;
	}

	@Override
	public void plow() {
		if(season==Season.SPRING){
			System.out.println("plow corn fields");
		}
		else if(season==Season.SUMMER){
			System.out.println("no action");
		}else{
			System.out.println("no action");
		}
	}

	@Override
	public void plant() {
		if(season==Season.SPRING){
			System.out.println("peas, lettuce, oats");
		}
		else if(season==Season.SUMMER){
			System.out.println("beans, squash, tomatoes, beets, carrots");
		}else{
			System.out.println("late beans, squash, potatoes");
		}
	}

	@Override
	public void weedControl() {
		if(season==Season.SPRING){
			System.out.println("walking cultivator in garden");
		}
		else if(season==Season.SUMMER){
			System.out.println("walking cultivator in garden, two row, horse-drawn cultivator in fields");
		}else{
			System.out.println("no action");
		}
	}

	@Override
	public void harvest() {
		if(season==Season.SPRING){
			System.out.println("wife and kids help out");
		}
		else if(season==Season.SUMMER){
			System.out.println("wife and kids help out in garden; neighbors help with oats and hay");
		}else{
			System.out.println("wife and kids help out in garden, neighbors help with corn and hay");
		}
	}

	@Override
	public void market() {
		if(season==Season.SPRING){
			System.out.println("jams, jellies, peas & lettuce to auction");
		}
		else if(season==Season.SUMMER){
			System.out.println("peas, carrots, early beans, roma tomatoes to auction");
		}else{
			System.out.println("beans, squash, tomatoes to auction");
		}
	}

}
