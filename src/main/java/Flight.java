import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;


public class Flight {

    private Plane plane;
    private String flightNumber;
    private Airports destination;
    private Airports departureAirport;
    private LocalDateTime departureTime;
    private ArrayList<Passenger> passengers;

    public Flight(Plane plane, String flightNumber, Airports destination, Airports departureAirport, String departureTime) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = LocalDateTime.parse(departureTime);
        this.passengers = new ArrayList<Passenger>();
    }


    public Plane getPlane() {
        return this.plane;
    }

    public ArrayList<Passenger> getPassengers(){
        return this.passengers;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airports getDestination() {
        return destination;
    }

    public Airports getDepartureAirport() {
        return departureAirport;
    }

    public String getDepartureTime() {
        return departureTime.toString();
    }

    public int countPassengers() {
        return this.passengers.size();
    }

    public int availableSeats() {
        return this.plane.getCapacity() - countPassengers();
    }

    public void bookPassenger(Passenger passenger) {
        if (availableSeats() >= 1){
            this.passengers.add(passenger);
            passenger.addFlight(this);
            generateSeatNumber(passenger);
        }
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = LocalDateTime.parse(departureTime);
    }

    public void generateSeatNumber(Passenger passenger){
        Random random = new Random();
        int seatNumber = random.nextInt(this.plane.getCapacity()) + 1;
        while (passenger.getSeat() == 0){
            for (int i = 0; i < this.countPassengers() -1; i++){
                if (this.passengers.get(i).getSeat() == seatNumber){
                    seatNumber = random.nextInt(this.plane.getCapacity()) + 1;
                    i = -1;
                }
            }
            passenger.setSeat(seatNumber);
        }
    }
}


// while passenger.getSeat() = 0