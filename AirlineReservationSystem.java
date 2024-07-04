package system;

import java.util.ArrayList;
import java.util.List;

public class AirlineReservationSystem {
    private List<Flight> flights;
    private List<Reservation> reservations;

    public AirlineReservationSystem() {
        this.flights = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addFlight(String flightNumber, String destination, int capacity) {
        flights.add(new Flight(flightNumber, destination, capacity));
    }

    public Flight findFlightByNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public Reservation makeReservation(String flightNumber, String passengerName, String passportNumber) {
        Flight flight = findFlightByNumber(flightNumber);
        if (flight != null && flight.bookSeat()) {
            Passenger passenger = new Passenger(passengerName, passportNumber);
            String reservationNumber = "RES" + (reservations.size() + 1);
            Reservation reservation = new Reservation(flight, passenger, reservationNumber);
            reservations.add(reservation);
            return reservation;
        }
        return null;
    }

    public boolean cancelReservation(String reservationNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationNumber().equals(reservationNumber)) {
                if (reservation.getFlight().cancelSeat()) {
                    reservations.remove(reservation);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public static void main(String[] args) {
        AirlineReservationSystem system = new AirlineReservationSystem();

        // Add some flights
        system.addFlight("FL001", "New York", 100);
        system.addFlight("FL002", "Los Angeles", 120);

        // Make a reservation
        Reservation reservation = system.makeReservation("FL001", "John Doe", "A12345678");
        if (reservation != null) {
            System.out.println("Reservation successful: " + reservation.getReservationNumber());
        } else {
            System.out.println("Reservation failed");
        }

        // Cancel a reservation
        boolean isCancelled = system.cancelReservation("RES1");
        if (isCancelled) {
            System.out.println("Reservation cancelled");
        } else {
            System.out.println("Cancellation failed");
        }
    }
}







