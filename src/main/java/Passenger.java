public class Passenger {

    private String name;
    private int bags;
    private Flight flight;
    private int seat;

    public Passenger(String name, int bags) {
        this.name = name;
        this.bags = bags;
    }

    public String getName() {
        return name;
    }

    public int getBags() {
        return bags;
    }

    public Integer getSeat() {
        return Integer.valueOf(this.seat);
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void addFlight(Flight flight) {
        this.flight = flight;
    }
}
