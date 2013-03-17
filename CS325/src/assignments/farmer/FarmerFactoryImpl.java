package assignments.farmer;

import assignments.farmer.farmers.Amish;
import assignments.farmer.farmers.Conventional;
import assignments.farmer.farmers.Organic;

public class FarmerFactoryImpl implements FarmerFactory {

	@Override
	public Farmer createConventionalFarmer(Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Farmer createOrganicFarmer(Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Farmer createAmishFarmer(Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Farmer createFarmer(Farmers farmerType, Season season) {
		if(farmerType==Farmers.CONVENTIONAL){
			return new Conventional(season);
		}else if(farmerType==Farmers.ORGANIC){
			return new Organic(season);
		}else{
			return new Amish(season);
		}
	}
}
