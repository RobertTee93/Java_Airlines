import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FlightManager {

    private ArrayList<Flight> flights;

    public FlightManager() {
        this.flights = new ArrayList<Flight>();
    }

    public int countFlights() {
        return this.flights.size();
    }


    public int availableBaggage(Flight flight) {
        Plane plane = flight.getPlane();
        return plane.getTotalWeight() / 2;
    }

    public int baggageBooked(Flight flight) {
        int baggageBooked = 0;
        int weightPerBag = availableBaggage(flight) / flight.getPlane().getCapacity();
        for (Passenger passenger : flight.getPassengers()){
            baggageBooked += weightPerBag * passenger.getBags();
        }

        return baggageBooked;
    }

    public int remainingBaggage(Flight flight) {
        return availableBaggage(flight) - baggageBooked(flight);
    }

    public ArrayList<Passenger> sortPassengersBySeat(Flight flight) {
        ArrayList<Passenger> sortedPassengers = flight.getPassengers();
        Passenger temp;
        for (int i = sortedPassengers.size() -1; i > 0; i--){

            boolean isSorted = true;

            for (int j = 0; j < i; j++){
                if (sortedPassengers.get(j + 1).getSeat() < sortedPassengers.get(j).getSeat()){
                    isSorted = false;
                    temp = sortedPassengers.get(j + 1);
                    sortedPassengers.set(j + 1, sortedPassengers.get(j));
                    sortedPassengers.set(j, temp);
                }

                }
            if (isSorted){
                break;
            }
        }
        return sortedPassengers;
    }

    public Passenger findPassengerBySeat(Flight flight, int seatNum) {
        sortPassengersBySeat(flight);
        Comparator<Passenger> comp = new Comparator<Passenger>() {
            public int compare(Passenger o1, Passenger o2) {
                return o1.getSeat().compareTo(o2.getSeat());
            }
        };
        Passenger passenger = new Passenger("Robert", 1);
        passenger.setSeat(seatNum);
        int index = Collections.binarySearch(flight.getPassengers(), passenger, comp);
        return flight.getPassengers().get(index);
    }
}
