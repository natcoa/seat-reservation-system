package Project2;

public class Seat {
	
	// Instance Variables
	String passengerName;
	boolean available;
	enum seatType {STANDARD, EXTRA_LEGROOM};
	seatType type;
	
	// Default Constructor
	public Seat() {
		passengerName = "";
		available = true;
		type = seatType.STANDARD;
		
	}
	
	// Overloaded Constructor
	public Seat(String n, boolean a, String t) {
		passengerName = n;
		available = a;
		type = seatType.valueOf(t);
		
	}
	
	// Getters
	public String getPassengerName() {
		return passengerName;
	}
	
	public boolean getAvailability() {
		return available;
	}
	
	public seatType getSeatType() {
		return type;
	}
	
	// Setters
	public void setPassengerName(String n) {
		passengerName = n;
	}
	
	public void setAvailability(boolean a) {
		available = a;
	}
	
	public void setSeatType(String t) {
		type = seatType.valueOf(t);
	}
	
	// toString method
	public String toString() {
		return "Passenger " + passengerName + "\n\tSeat Type " + type;
	}

}
