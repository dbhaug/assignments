package assignments.farmer;

public interface FarmerFactory {
	public Farmer createConventionalFarmer(Season season);
	public Farmer createOrganicFarmer(Season season);
	public Farmer createAmishFarmer(Season season);
	public Farmer createFarmer(Farmers farmerType,Season season);
}
