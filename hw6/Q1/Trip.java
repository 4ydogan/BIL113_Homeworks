public class Trip{

	String companyName, source, destination, departureTime, arrivalTime, seatType;
	int ticketPrice, numberOfSeats, numberOfTicketsSold;
	Date date;

	public Trip(){}

	public Trip(String companyName1, String source1, String destination1, String departureTime1, String arrivalTime1, String seatType1, int ticketPrice1, int numberOfSeats1, int numberOfTicketsSold1, Date date1){

		companyName = companyName1;
		source = source1;
		destination = destination1;
		departureTime = departureTime1;
		arrivalTime = arrivalTime1;
		seatType = seatType1;
		ticketPrice = ticketPrice1;
		numberOfSeats = numberOfSeats1;
		numberOfTicketsSold = numberOfTicketsSold1;
		date = date1;

	}

	public Trip(String companyName1, String source1, String destination1, int ticketPrice1, Date date1, String departureTime1, String arrivalTime1, String seatType1, int numberOfSeats1){

		companyName = companyName1;
		source = source1;
		destination = destination1;
		departureTime = departureTime1;
		arrivalTime = arrivalTime1;
		seatType = seatType1;
		ticketPrice = ticketPrice1;
		numberOfSeats = numberOfSeats1;
		numberOfTicketsSold = 0;
		date = date1;

	}

	public String toString( ) {

		return String.format("%s tarihinde %s saatinde %s sehrinden %s sehrine %s firmasinin %s araci bulunmaktadir. Fiyat: %d TL, bos koltuk sayisi:%d",
			date.toString(), departureTime, source, destination, companyName, seatType, ticketPrice , (numberOfSeats - numberOfTicketsSold));
	}

	public Date getDate(){

		return date;
	}
	
	public String getDepartureTime(){

		return departureTime;
	}

	public String getSource(){

		return source;
	}

	public String getDestination(){

		return destination;
	}

	public String getCompanyName(){

		return companyName;
	}

	public String getSeatType(){

		return seatType;
	}

}