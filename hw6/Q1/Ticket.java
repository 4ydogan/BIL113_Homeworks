public class Ticket{
	
	public static int pnrNoInt = 0; // to create a pnrNo in TripReservation class
	String customerName, customerSurname, gender, pnrNo;
	Trip trip;

	public Ticket(String customerName1, String customerSurname1, String gender1, Trip trip1, String pnrNo1){

		customerName = customerName1;
		customerSurname = customerSurname1;
		gender = gender1;
		trip = trip1;
		pnrNo = pnrNo1;
	}

	public Ticket(){}

	public String toString(){
		
		return String.format("Ad soyad:%s %s Yolculuk tarihi:%s Saat:%s Kalkis:%s Varis:%s  Firma:%s Koltuk Tipi:%s PNR:%s", 
			customerName, customerSurname, trip.getDate().toString(), trip.getDepartureTime(), trip.getSource(), 
			trip.getDestination(), trip.getCompanyName(), trip.getSeatType(), pnrNo) ;

	}

	public String getPnrNo(){

		return pnrNo;
	}

}