import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    public Passenger passenger;
    public Flight flight;
    public Plane plane;

    @Before
    public void setUp(){
        plane = new Plane(PlaneTypes.BOEING767);
        flight = new Flight(plane, "GL767", Airports.GLA, Airports.EDI, "2018-05-05T11:50");
        passenger = new Passenger("Robert", 2);

    }

    @Test
    public void hasName() {
        assertEquals("Robert", passenger.getName());
    }

    @Test
    public void hasBags() {
        assertEquals(2, passenger.getBags());
    }

    @Test
    public void hasFlight(){
        passenger.addFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void canGetSeatNumber(){
        passenger.setSeat(2);
        Integer num = 2;
        assertEquals(num , passenger.getSeat());
    }


}
