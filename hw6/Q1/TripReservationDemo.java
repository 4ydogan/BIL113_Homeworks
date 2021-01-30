import java.util.ArrayList;

public class TripReservationDemo {

    private ArrayList<BusCompany> companies = new ArrayList<>();

    public static void main(String[] args) {
        BusCompany luxMersin = new BusCompany("Luks Mersin", createTripsForLuksMersin());
        BusCompany mersinVif = new BusCompany("Mersin Vif", createTripsForVif());
        BusCompany koksallar = new BusCompany("Koksallar", createTripsForKoksallar());
        BusCompany metro = new BusCompany("Metro", createTripsForMetro());

        ArrayList<BusCompany> companies = new ArrayList<>();
        companies.add(luxMersin);
        companies.add(mersinVif);
        companies.add(koksallar);
        companies.add(metro);
        TripReservation searcher = new TripReservation(companies);

        System.out.println("Kayitli sirketler:");
        searcher.printAllRegisteredCompanies();



        System.out.println();
        System.out.println("1/12/2020 tarihinde Mersinden Ankara'ya giden araclar:");
        ArrayList<Trip> allTrips = searcher.findAllTrips("Mersin", "Ankara", new Date(1, 12, 2020));
        for (int i = 0; i < allTrips.size(); i++)
            System.out.println(allTrips.get(i));


        System.out.println();
        System.out.println("En uygun fiyatli arac");
        System.out.println(searcher.findCheapestTrip("Mersin", "Ankara", new Date(1, 12, 2020)));


        System.out.println();
        System.out.println("1/12/2020 tarihinde Mersinden Istanbul'a giden araclar:");
        allTrips = searcher.findAllTrips("Mersin", "Istanbul", new Date(1, 12, 2020));
        for (int i = 0; i < allTrips.size(); i++)
            System.out.println(allTrips.get(i));


        System.out.println();
        System.out.println("En uygun fiyatli arac");
        System.out.println(searcher.findCheapestTrip("Mersin", "Istanbul", new Date(1, 12, 2020)));


        System.out.println();
        System.out.println("3/12/2020 ve 5/12/2020 arasi tarihlerde Mersinden Istanbul'a giden araclar:");
        allTrips = searcher.findAllTrips("Mersin", "Istanbul", new Date(3, 12, 2020), new Date(5, 12,2020));
        for (int i = 0; i < allTrips.size(); i++)
            System.out.println(allTrips.get(i));

        System.out.println();
        System.out.println("En uygun fiyatli arac");
        Trip cheapestTrip = searcher.findCheapestTrip("Mersin", "Istanbul", new Date("03/12/2020"), new Date(5, 12, 2020));
        System.out.println(cheapestTrip);

        System.out.println();
        System.out.println("3/12/2020 ve 5/12/2020 arasi tarihlerde Mersinden Istanbul'a giden  2+1 araclar:");
        allTrips = searcher.findAllTrips("Mersin", "Istanbul", new Date(3, 12, 2020), new Date(5, 12,2020), "2+1");
        for (int i = 0; i < allTrips.size(); i++)
            System.out.println(allTrips.get(i));

        System.out.println();
        System.out.println("En uygun fiyatli 2+1 arac");
        cheapestTrip = searcher.findCheapestTrip("Mersin", "Istanbul", new Date("03/12/2020"), new Date(5, 12, 2020), "2+1");
        System.out.println(cheapestTrip);

        System.out.println();
        System.out.println("Bu bileti alalim");
        Ticket ticket1 = searcher.sellTicket(cheapestTrip, "Utku Umur", "ACIKALIN", "Male");
        if (ticket1 != null) {
            System.out.println("Bilgileriniz asagidaki gibidir.");
            System.out.println(ticket1);
        } else {
            System.out.println("Otobuste yer olmadigi icin bilet alinamadi");
        }

        System.out.println();
        System.out.println("Bilet satin alindiktan sonraki durum");
        System.out.println(cheapestTrip);
        System.out.println();

        System.out.println("Aynı otobusten bilet almaya calisalim");

        Ticket ticket2 = searcher.sellTicket(cheapestTrip, "Utku Umur", "ACIKALIN", "Male");
        if (ticket2 != null) {
            System.out.println("Bilgileriniz asagidaki gibidir.");
            System.out.println(ticket2);
        } else {
            System.out.println("Otobuste yer olmadigi icin bilet alinamadi");
        }


        System.out.println();
        System.out.println("Aldigimiz bileti iptal edelim");
        boolean cancelStatus = searcher.cancelTicket("ACIKALIN", ticket1.getPnrNo());
        if (cancelStatus) {
            System.out.println("Bilet basariyla iptal edildi.");
        } else {
            System.out.println("Belirtmis oldugunuz bilet sistemde bulunamadi.");
        }

        System.out.println("Iptal ettiğimiz bileti bir daha iptal etmeye calisalim");
        cancelStatus = searcher.cancelTicket("ACIKALIN", ticket1.getPnrNo());
        if (cancelStatus) {
            System.out.println("Bilet basariyla iptal edildi.");
        } else {
            System.out.println("Belirtmis oldugunuz bilet sistemde bulunamadi.");
        }

        System.out.println();
        System.out.println("Bilet iptal edildikten  sonraki durum");
        System.out.println(cheapestTrip);

        System.out.println();
        System.out.println("Tekrar alalim");
        ticket2 = searcher.sellTicket(cheapestTrip, "Utku Umur", "ACIKALIN", "Male");
        if (ticket2 != null) {
            System.out.println("Bilgileriniz asagidaki gibidir.");
            System.out.println(ticket2);
        } else {
            System.out.println("Otobuste yer olmadigi icin bilet alinamadi");
        }

        System.out.println();
        System.out.println("Bilet satin alindiktan sonraki durum");
        System.out.println(cheapestTrip);




    }


    private static ArrayList<Trip> createTripsForCompany(String company, String source, String destination, int ticketPrice, Date date1, Date date2, String departureTime, String arrivalTime, String seatType, int numberOfSeats) {
        ArrayList<Trip> trips = new ArrayList<>();
        Date date = date1;
        while (date.compareTo(date2) <= 0) {
            trips.add(new Trip(company, source, destination, ticketPrice, date, departureTime, arrivalTime, seatType, numberOfSeats));
            date = new Date(date.getDay() + 1, date.getMonth(), date.getYear());
        }

        return  trips;
    }

    private static ArrayList<Trip> createTripsForLuksMersin() {
        ArrayList<Trip> trips = new ArrayList<>();
        trips.addAll(createTripsForCompany("Luks Mersin", "Mersin", "Ankara", 60, new Date("1/12/2020"),
                new Date("31/12/2020"), "00:30", "07:00", "2+1", 48));
        trips.addAll(createTripsForCompany("Luks Mersin", "Mersin", "Ankara", 60, new Date("1/12/2020"),
                new Date("31/12/2020"), "09:00", "16:00", "2+1", 48));
        trips.addAll(createTripsForCompany("Luks Mersin", "Mersin", "Ankara", 60, new Date("1/12/2020"),
                new Date("31/12/2020"), "13:00", "21:00", "2+1", 48));
        trips.addAll(createTripsForCompany("Luks Mersin", "Mersin", "Ankara", 55, new Date("1/12/2020"),
                new Date("31/12/2020"), "17:00", "23:59", "2+2", 54));


        trips.addAll(createTripsForCompany("Luks Mersin", "Mersin", "Istanbul", 120, new Date("1/12/2020"),
                new Date("31/12/2020"), "00:30", "15:00", "2+1", 48));
        trips.addAll(createTripsForCompany("Luks Mersin", "Mersin", "Istanbul", 100, new Date("1/12/2020"),
                new Date("31/12/2020"), "09:30", "23:59", "2+2", 48));


        return  trips;
    }

    private static ArrayList<Trip> createTripsForVif() {
        ArrayList<Trip> trips = new ArrayList<>();
        trips.addAll(createTripsForCompany("Mersin Vif", "Mersin", "Ankara", 70, new Date("1/12/2020"),
                new Date("31/12/2020"), "13:00", "23:30", "2+1", 48));
        trips.addAll(createTripsForCompany("Mersin Vif", "Mersin", "Ankara", 70, new Date("1/12/2020"),
                new Date("31/12/2020"), "23:30", "07:00", "2+1", 48));

        trips.addAll(createTripsForCompany("Mersin Vif", "Mersin", "Istanbul", 125, new Date("1/12/2020"),
                new Date("31/12/2020"), "18:00", "08:30", "2+1", 48));

        return  trips;
    }

    private static ArrayList<Trip> createTripsForKoksallar() {
        ArrayList<Trip> trips = new ArrayList<>();
        trips.addAll(createTripsForCompany("Koksallar", "Mersin", "Ankara", 70, new Date("1/12/2020"),
                new Date("31/12/2020"), "09:30", "16:30", "2+1", 48));
        trips.addAll(createTripsForCompany("Koksallar", "Mersin", "Ankara", 70, new Date("1/12/2020"),
                new Date("31/12/2020"), "16:00", "22:30", "2+1", 48));
        trips.addAll(createTripsForCompany("Koksallar", "Mersin", "Ankara", 65, new Date("1/12/2020"),
                new Date("31/12/2020"), "23:30", "07:00", "2+2", 48));

        trips.addAll(createTripsForCompany("Koksallar", "Mersin", "Istanbul", 120, new Date("1/12/2020"),
                new Date("31/12/2020"), "20:30", "10:30", "2+2", 36));


        return  trips;
    }

    private static ArrayList<Trip> createTripsForMetro() {
        ArrayList<Trip> trips = new ArrayList<>();
        trips.addAll(createTripsForCompany("Metro", "Mersin", "Istanbul", 115, new Date("1/12/2020"),
                new Date("31/12/2020"), "21:00", "10:30", "2+1", 1));


        trips.addAll(createTripsForCompany("Metro", "Istanbul", "Mersin", 150, new Date("1/12/2020"),
                new Date("31/12/2020"), "16:30", "07:30", "2+1", 26));



        return  trips;
    }
}
