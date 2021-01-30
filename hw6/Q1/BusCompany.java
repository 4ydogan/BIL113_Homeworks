import java.util.ArrayList;

public class BusCompany{

	String companyName;
	ArrayList<Trip> trips = new ArrayList<>();

	public BusCompany(){}
	
	public BusCompany(String name, ArrayList<Trip> designatedTrips){
		
		companyName = name;
		trips = designatedTrips;

	}
}