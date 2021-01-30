import java.util.ArrayList;

public class TripReservation {
	
	ArrayList<BusCompany> registeredBusCompanies = new ArrayList<>();
	ArrayList<Ticket> soldTickets = new ArrayList<>();
	ArrayList<Trip> designatedTrips = new ArrayList<>();

	public TripReservation(){}

	public TripReservation(ArrayList<BusCompany> registeredBusCompanies1){

		registeredBusCompanies = registeredBusCompanies1;

		for (int i=0; i <= registeredBusCompanies.size()-1 ; i++ ) {

			for (int j=0; j <= ((registeredBusCompanies.get(i)).trips).size()-1; j++){

				designatedTrips.add(registeredBusCompanies.get(i).trips.get(j));
			}
		}
		
	}

	public void printAllRegisteredCompanies(){ // to print all companies

		for (int i= 0; i <= registeredBusCompanies.size()-1 ; i++) {

			System.out.println((registeredBusCompanies.get(i)).companyName);
		}
	}

	public ArrayList<Trip> findAllTrips(String source, String destination, Date date1, Date date2, String seatType){ // to find trips 

		ArrayList<Trip> result = new ArrayList<>();

		for (int i=0; i <= designatedTrips.size()-1; i++ ) {

			Trip trip = new Trip();
			trip = designatedTrips.get(i);

			if ((trip.source).equals(source) == true) {

				if ((trip.destination).equals(destination) == true) {
					
					if ((trip.date).compareTo(date1) >= 0 && (trip.date).compareTo(date2) <= 0) {

						if ((trip.seatType).equals(seatType) == true) {
							
							result.add(trip);
						}
						
					}

				}
			
			}
		}

		return result;
	}

	public ArrayList<Trip> findAllTrips(String source, String destination, Date date1){ // overloading
		
		ArrayList<Trip> result = new ArrayList<>();

		for (int i=0; i <= designatedTrips.size()-1; i++ ) {

			Trip trip = new Trip();
			trip = designatedTrips.get(i);

			if ((trip.source).equals(source) == true) {

				if ((trip.destination).equals(destination) == true) {
					
					if ((trip.date).compareTo(date1) == 0) {

						result.add(trip);
						
					}

				}
			
			}
		}

		return result;
	}

	public ArrayList<Trip> findAllTrips(String source, String destination, Date date1, String seatType){ // overloading
		
		ArrayList<Trip> result = new ArrayList<>();

		for (int i=0; i <= designatedTrips.size()-1; i++ ) {

			Trip trip = new Trip();
			trip = designatedTrips.get(i);

			if ((trip.source).equals(source) == true) {

				if ((trip.destination).equals(destination) == true) {
					
					if ((trip.date).compareTo(date1) == 0) {

						if ((trip.seatType).equals(seatType) == true) {
							
							result.add(trip);
						}
						
					}

				}
			
			}
		}

		return result;
	}

	public ArrayList<Trip> findAllTrips(String source, String destination, Date date1, Date date2){ // overloading
		
		ArrayList<Trip> result = new ArrayList<>();

		for (int i=0; i <=designatedTrips.size()-1; i++ ) {

			Trip trip = new Trip();
			trip = designatedTrips.get(i);

			if ((trip.source).equals(source) == true) {

				if ((trip.destination).equals(destination) == true) {
					
					if ((trip.date).compareTo(date1) >= 0 && (trip.date).compareTo(date2) <= 0) {
							
						result.add(trip);
					}

				}
			
			}
		}

		return result;
	}

	public Trip findCheapestTrip(String source, String destination, Date date1, Date date2, String seatType){ // to find cheapest trip

		int minPrice = Integer.MAX_VALUE;
		Trip cheapestTrip = new Trip();

		ArrayList<Trip> allTrips = new ArrayList<Trip>();
		allTrips = findAllTrips(source, destination, date1, date2, seatType);

		for (int i=0; i <= allTrips.size()-1 ; i++ ) {

			if ((allTrips.get(i)).ticketPrice < minPrice) { // 
				
				minPrice = (allTrips.get(i)).ticketPrice;
				cheapestTrip = allTrips.get(i);
			}
		}

		return cheapestTrip;

	}

	public Trip findCheapestTrip(String source, String destination, Date date1, String seatType){ // overloading

		int minPrice = Integer.MAX_VALUE;
		Trip cheapestTrip = new Trip();

		ArrayList<Trip> allTrips = new ArrayList<Trip>();
		allTrips = findAllTrips(source, destination, date1, seatType);

		for (int i=0; i <= allTrips.size()-1 ; i++ ) {

			if ((allTrips.get(i)).ticketPrice < minPrice) {
				
				minPrice = (allTrips.get(i)).ticketPrice;
				cheapestTrip = allTrips.get(i);
			}
		}

		return cheapestTrip;

	}

	public Trip findCheapestTrip(String source, String destination, Date date1, Date date2){ // overloading

		int minPrice = Integer.MAX_VALUE;
		Trip cheapestTrip = new Trip();

		ArrayList<Trip> allTrips = new ArrayList<Trip>();
		allTrips = findAllTrips(source, destination, date1, date2);

		for (int i=0; i <= allTrips.size()-1 ; i++ ) {

			if ((allTrips.get(i)).ticketPrice < minPrice) {
				
				minPrice = (allTrips.get(i)).ticketPrice;
				cheapestTrip = allTrips.get(i);
			}
		}

		return cheapestTrip;

	}

	public Trip findCheapestTrip(String source, String destination, Date date1){ // overloading

		int minPrice = Integer.MAX_VALUE;
		Trip cheapestTrip = new Trip();

		ArrayList<Trip> allTrips = new ArrayList<Trip>();
		allTrips = findAllTrips(source, destination, date1);

		for (int i=0; i <= allTrips.size()-1 ; i++ ) {

			if ((allTrips.get(i)).ticketPrice < minPrice) {
				
				minPrice = (allTrips.get(i)).ticketPrice;
				cheapestTrip = allTrips.get(i);
			}
		}

		return cheapestTrip;

	}

	public Ticket sellTicket(Trip trip, String customerName1, String customerSurname1, String gender1){ // to sell tickets

   		if (trip.numberOfSeats - trip.numberOfTicketsSold > 0) {
			
			int pnrNo=Ticket.pnrNoInt;
        	Ticket.pnrNoInt++;              // to create a uniqe pnrNo

        	Ticket soldTicket = new Ticket(customerName1, customerSurname1, gender1, trip, ""+pnrNo);

			soldTicket.customerName = customerName1;
			soldTicket.customerSurname = customerSurname1;
			soldTicket.gender = gender1;

			trip.numberOfTicketsSold++;
			soldTickets.add(soldTicket);
			return soldTicket;

		}

		else{

			return null;
		}

	}

	public boolean cancelTicket(String customerSurname1, String pnrNo1){ // to cancel a sold ticket

		boolean kontrol = false;

		for (int i=0; i <= soldTickets.size()-1 ; i++ ) {

			if(soldTickets.get(i).customerSurname.equals(customerSurname1) == true ){

				if (pnrNo1.equals(soldTickets.get(i).pnrNo) == true) {
					
					Trip changedTrip = new Trip();
					changedTrip = soldTickets.remove(i).trip;
					changedTrip.numberOfTicketsSold--;
					kontrol = true;
					designatedTrips.add(changedTrip);
				}
			}			
		}

		return kontrol;
	}
}