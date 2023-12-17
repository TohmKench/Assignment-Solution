package ie.lyit.testers;

import ie.lyit.flight.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class BookingTest {

    private Booking booking1;
    private Flight f1;
    private Flight f2;
    private ArrayList<Passenger> list1;
    private Passenger p1;
    private List<Booking> bookings;
    @Before
    public void setUp() throws Exception {
        bookings = new ArrayList<>();

        f1 = new Flight("1", "Donegal", "Dublin", new Date(13, 12, 2023), new Time(12, 40), 15.99);
        f2 = new Flight("2", "Dublin", "Cork", new Date(15, 12, 2018), new Time(10, 25), 14.99);
        list1 = new ArrayList<>();
        p1 = new Passenger(new Name("Mr", "Homer", "Simpson"), "555555555", "homer@atu.ie", 1, false, null);
        list1.add(p1);
        booking1 = new Booking(f1, f2, list1); 
        bookings.add(booking1);

        // Add more bookings as needed
        Flight f3 = new Flight("3", "Belfast", "Dublin", new Date(04, 05, 2024), new Time(10, 10), 20.50);
        Flight f4 = new Flight("4", "Dublin", "Belfast", new Date(17, 12, 2023), new Time(11, 45), 25.99);
        Passenger p2 = new Passenger(new Name("Mr", "Bart", "Simpson"), "1231231231", "bart@atu.ie", 1, false, null);
        Passenger p3 = new Passenger(new Name("Mrs", "Lisa", "Simpson"), "1234567890", "lisa@atu.ie", 1, false, null);
        ArrayList<Passenger> list2 = new ArrayList<>();
        list2.add(p2);
        list2.add(p3);
        bookings.add(new Booking(f3, f4, list2));
    }



    @Test
    public void testBookingFlightFlightArrayListOfPassenger() {
        assertEquals(booking1.getOutbound(), f1);
        assertEquals(booking1.getInbound(), f2);
        assertEquals(booking1.getPassengers(), list1);
        assertEquals(booking1.getPassengers().isEmpty(), false);
        assertEquals(booking1.getPassengers().size(), 1);
    }

    @Test
    public void testSetOutbound() {
        Flight f3 = new Flight("3", "Belfast", "Dublin", new Date(20, 11, 2018), new Time(11, 30), 16.99);
        booking1.setOutbound(f3);
        assertEquals(booking1.getOutbound(), f3);
    }


    @Test
    public void testSetInbound() {
        Flight f4 = new Flight("4", "Dublin", "London", new Date(21, 11, 2018), new Time(11, 45), 17.99);
        booking1.setInbound(f4);
        assertEquals(booking1.getInbound(), f4);
    }


    @Test
    public void testSetTotalPrice() {
        booking1.setTotalPrice();
        assertEquals(booking1.getTotalPrice(), 25.99, 0);
    }


    @Test
    public void testFindPassenger() {
        assertEquals(booking1.findPassenger(p1), true);
    }

    @Test
    public void testCalculatePrice() {
        booking1.calculatePrice();
        assertEquals(booking1.getTotalPrice(), 25.99, 0);
    }
}
