import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    public Flight flight;
    public Plane plane;
    public Passenger passenger;
    public Passenger passenger1;
    public Passenger passenger2;
    public Passenger passenger3;
    public Passenger passenger4;
    public FlightManager flightManager;

    @Before
    public void setUp() {
        plane = new Plane(PlaneTypes.BOEING767);
        flight = new Flight(plane, "GL767", Airports.GLA, Airports.EDI, "2018-05-05T11:50");
        passenger = new Passenger("Robert", 1);
        passenger1 = new Passenger("Max", 1);
        passenger2 = new Passenger("Claire", 1);
        passenger3 = new Passenger("Thomas", 1);
        passenger4 = new Passenger("Martin", 1);
        flightManager = new FlightManager();
    }

    @Test
    public void shouldStartWithNoFlights(){
        assertEquals(0, flightManager.countFlights());
    }

    @Test
    public void canCalculateBaggageForFlight(){
        assertEquals(100, flightManager.availableBaggage(flight));
    }

    @Test
    public void canCalculateTotalBaggageBookedByPassengers(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        assertEquals(75, flightManager.baggageBooked(flight));
    }

    @Test
    public void canCalculateRemainingBaggage(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        assertEquals(50, flightManager.remainingBaggage(flight));
    }

    @Test
    public void canSortPassengersBySeatNumber(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        passenger1.setSeat(2);
        passenger2.setSeat(3);
        passenger3.setSeat(1);
        passenger4.setSeat(4);
        ArrayList<Passenger> sortedPassengers = flightManager.sortPassengersBySeat(flight);
        assertEquals(passenger2, sortedPassengers.get(2));
    }

    @Test
    public void canFindPassengerBySeatNumber(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        passenger1.setSeat(2);
        passenger2.setSeat(3);
        passenger3.setSeat(1);
        passenger4.setSeat(4);
        flightManager.sortPassengersBySeat(flight);
        assertEquals(passenger4, flightManager.findPassengerBySeat(flight, 4));
    }

}
