import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    public Flight flight;
    public Plane plane;
    public Passenger passenger1;
    public Passenger passenger2;
    public Passenger passenger3;
    public Passenger passenger4;

    @Before
    public void setUp() {
        plane = new Plane(PlaneTypes.BOEING767);
        flight = new Flight(plane, "GL767", Airports.GLA, Airports.EDI, "2018-05-05T11:50");
        passenger1 = new Passenger("Robert", 1);
        passenger2 = new Passenger("Claire", 1);
        passenger3 = new Passenger("Thomas", 1);
        passenger4 = new Passenger("Martin", 1);
    }

    @Test
    public void hasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasFlightNumber(){
        assertEquals("GL767", flight.getFlightNumber());
    }

    @Test
    public void hasDestinationAirport(){
        assertEquals(Airports.GLA, flight.getDestination());
    }

    @Test
    public void hasDepartureAirport(){
        assertEquals(Airports.EDI, flight.getDepartureAirport());
    }

    @Test
    public void hasDepartureTime(){
        assertEquals( "2018-05-05T11:50", flight.getDepartureTime());
    }

    @Test
    public void canChangeDepartureTime(){
        flight.setDepartureTime("2017-03-05T11:50");
        assertEquals("2017-03-05T11:50", flight.getDepartureTime());
    }

    @Test
    public void shouldStartWithNoPassengers(){
        assertEquals(0, flight.countPassengers());
    }

    @Test
    public void canGetAvailableSeats(){
        assertEquals(4, flight.availableSeats());
    }

    @Test
    public void canBookPassenger(){
        flight.bookPassenger(passenger1);
        assertEquals(1, flight.countPassengers());
    }

    @Test
    public void shouldNotAddPassenger__ifNoSpace(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        assertEquals(4, flight.countPassengers());
    }

    @Test
    public void shouldAssignFlightToPassengerOnBookIn(){
        flight.bookPassenger(passenger1);
        assertEquals(flight, passenger1.getFlight());
    }

    @Test
    public void shouldNotAssignDuplicateNumbers(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        passenger1.setSeat(1);
        passenger2.setSeat(2);
        passenger3.setSeat(4);
        flight.bookPassenger(passenger4);
        Integer num = 3;
        assertEquals(num, passenger4.getSeat());
    }

}
