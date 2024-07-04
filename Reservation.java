package system;

public class Reservation {
    private Flight flight;
    private Passenger passenger;
    private String reservationNumber;

    public Reservation(Flight flight, Passenger passenger, String reservationNumber) {
        this.flight = flight;
        this.passenger = passenger;
        this.reservationNumber = reservationNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }
}
