package ie.lyit.flight;

import java.util.ArrayList;

public class Booking {

    public static int MAX_PASSENGERS = 9;
    private Flight outbound;
    private Flight inbound;
    private ArrayList<Passenger> passengers;
    private double totalPrice;
    private int bookingNo;
    private static int nextUniqueBookingNumber = 10000;

    public Booking(Flight outbound, Flight inbound, ArrayList<Passenger> passengers) {
        if (outbound == null) {
            throw new IllegalArgumentException("Outbound Flight cannot Be Null");
        }
        if (passengers.isEmpty() || passengers.size() > MAX_PASSENGERS) {
            throw new IllegalArgumentException("Invalid Number Of Passengers");
        }
        this.outbound = outbound;
        this.inbound = inbound;
        this.passengers = passengers;
        this.totalPrice = calculatePrice();
        this.bookingNo = generateBookingNumber();
    }

    private int generateBookingNumber() {
        int bookingNumber = nextUniqueBookingNumber;
        nextUniqueBookingNumber++;
        return bookingNumber;
    }

   


    public boolean findPassenger(Passenger p) {
        return passengers.contains(p);
    }

    public void setInbound(Flight inbound) {
        this.inbound = inbound;
        setTotalPrice();
    }
    
    public void setOutbound(Flight outbound) {
        if (outbound == null) {
            throw new IllegalArgumentException("Outbound Flight Cannot Be Null");
        }
        this.outbound = outbound;
        setTotalPrice();
    }



    public void setPassengers(ArrayList<Passenger> passengers) {
        if (passengers.isEmpty() || passengers.size() > MAX_PASSENGERS) {
            throw new IllegalArgumentException("Invalid Amount of Passengers");
        }
        this.passengers = passengers;
        setTotalPrice();
    }

    public void setTotalPrice() {
        this.totalPrice = calculatePrice();
    }
    
    public Flight getInbound() {
        return inbound;
    }
    
    public Flight getOutbound() {
        return outbound;
    }


    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    @Override
	public String toString() {
		   return "Booking Number: " + getBookingNo() 
		   					+"\nInbound flight: " + getInbound()+ 
		   					"\nOutbound flight: " + getOutbound() + 
		   					"\nPassenger is: " + getPassengers() + 
		   					"\nTotal price is: " + getTotalPrice();
		}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Booking booking = (Booking) obj;
        return bookingNo == booking.bookingNo;
    }
    
    public double calculatePrice() {
		totalPrice = (inbound.getPrice() + outbound.getPrice()) * passengers.size();
		return totalPrice;
	}
}