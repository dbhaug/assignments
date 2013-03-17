package assignments.farmer.farmers;

import assignments.farmer.Farmer;
import assignments.farmer.Season;

public class Conventional implements Farmer {
	
	private Season season;

	public Conventional(Season season){
		this.season=season;
	}
	
	@Override
	public void plow() {
		if(season==Season.SPRING){
			System.out.println("using no-till; no plowing");
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
			System.out.println("no action");
		}
		else if(season==Season.SUMMER){
			System.out.println("corn");
		}else{
			System.out.println("no action");
		}
	}

	@Override
	public void weedControl() {
		if(season==Season.SPRING){
			System.out.println("no action");
		}
		else if(season==Season.SUMMER){
			System.out.println("spray");
		}else{
			System.out.println("no action");
		}
	}

	@Override
	public void harvest() {
		if(season==Season.SPRING){
			System.out.println("nothing to harvest");
		}
		else if(season==Season.SUMMER){
			System.out.println("nothing to harvest");
		}else{
			System.out.println("hire combine");
		}
	}

	@Override
	public void market() {
		if(season==Season.SPRING){
			System.out.println("nothing to market");
		}
		else if(season==Season.SUMMER){
			System.out.println("nothing to market");
		}else{
			System.out.println("feed corn to elevator");
		}
	}
}
