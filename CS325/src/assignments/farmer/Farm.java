package assignments.farmer;

public class Farm {
	public static void main(String[] args){
		FarmerFactory factory=new FarmerFactoryImpl();
		farm(factory);
	}

	private static void farm(FarmerFactory factory) {
		Farmer farmer;
		Season season;
		Farmers type;
		for(int i=0;i<3;i++){
			type=Farmers.values()[i];
			System.out.println("\n"+type.toString());
			for(int j=0;j<3;j++){
				season=Season.values()[j];
				System.out.println("\n"+season.toString());
				farmer=factory.createFarmer(type,season);
				cycle(farmer);
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void cycle(Farmer farmer){
		System.out.println("\n"+"Plow");
		farmer.plow();
		System.out.println("\n"+"Plant");
		farmer.plant();
		System.out.println("\n"+"Weed Control");
		farmer.weedControl();
		System.out.println("\n"+"Harvest");
		farmer.harvest();
		System.out.println("\n"+"Market");
		farmer.market();
	}
	
}
