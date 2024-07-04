package system;

public class Flight {
    private String flightNumber;
    private String destination;
    private int capacity;
    private int seatsBooked;

    public Flight(String flightNumber, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.capacity = capacity;
        this.seatsBooked = 0;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public boolean bookSeat() {
        if (seatsBooked < capacity) {
            seatsBooked++;
            return true;
        }
        return false;
    }

    public boolean cancelSeat() {
        if (seatsBooked > 0) {
            seatsBooked--;
            return true;
        }
        return false;
    }
}

