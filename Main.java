package Project2;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Seat[][] plane = {{new Seat("Tony Stark", false, "EXTRA_LEGROOM"), new Seat(), new Seat()},
						  {new Seat("Miles Morales", false, "STANDARD"), new Seat("Peter Parker", false, "STANDARD"), new Seat("MJ Watson", false, "EXTRA_LEGROOM")},
						  {new Seat(), new Seat("Nick Fury", false, "EXTRA_LEGROOM"), new Seat("Stephen Strange", false, "STANDARD")},
						  {new Seat(), new Seat(), new Seat("Wade Wilson", false, "STANDARD")}};
		
		System.out.println("Welcome to the Plane Seat Selection program!\n");
		int choice;
		do {
			System.out.println("Main Menu:");
			System.out.println("   1 - Print Current Seat Status");
			System.out.println("   2 - Print Current Passenger List");
			System.out.println("   3 - Reserve a Seat");
			System.out.println("   4 - Find a Passnenger");
			System.out.println("   5 - EXIT PROGRAM");
			choice = scan.nextInt();
			
			if (choice == 1) {
				printCurrentSeatStatus(plane);
				System.out.println("");
			}
			else if (choice == 2) {
				printPassengerList(plane);
				System.out.println("");
			}
			else if (choice == 3) {
				boolean t = false;
				int row = 0;
				String letter = "";
				System.out.println("\nReserving Seat...");
				while (!t) {
					System.out.println("Enter Passenger Name: ");
					scan.nextLine();
					String name = scan.nextLine();
					System.out.println("What row would you like to sit in? (1, 2, 3, or 4?)");
					row = scan.nextInt();
					System.out.println("What seat would you like in row " + row + "? (A, B, or C?)");
					scan.nextLine();
					letter = scan.nextLine().toUpperCase();
					t = selectSeat(row, letter, name, plane);
					if (!t) {
						System.out.println("ERROR - Seat Unavailable. Try again.");
					}
				}
				System.out.println("Seat " + row + letter + " successfully reserved.\n");
			}
			else if (choice == 4) {
				System.out.println("What is the name of the passenger you are searcing for?");
				scan.nextLine();
				String name = scan.nextLine();
				findPassenger(name, plane);
			}
			else if (choice == 5) {
				System.out.println("Seat Selection Program Terminated Successfully.");
				}
			else {
				System.out.println("ERROR - Enter a valid menu option.\n");
			}
		} while (choice != 5);
	}
	
	// Static Methods 
	/*
	 * printCurrentSeatStatus iterates through the passed-in plane array containing all the seats and prints out
	 * every taken seat using the getAvailability() method. Prints out passengers name, seat row, and seat number
	 * in a list. 
	 * 
	 * @param p : the 2D array containing all the seats
	 */
	public static void printCurrentSeatStatus(Seat[][] p) {
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				if (j == 0) {
					if (p[i][j].getAvailability()) {
						System.out.print((i + 1) + "A A\t");
					} else {
						System.out.print((i + 1) + "A X\t");
					}
				}
				if (j == 1) {
					if (p[i][j].getAvailability()) {
						System.out.print((i + 1) + "B A\t");
					} else {
						System.out.print((i + 1) + "B X\t");
					}
				}
				if (j == 2) {
					if (p[i][j].getAvailability()) {
						System.out.print((i + 1) + "C A\t");
					} else {
						System.out.print((i + 1) + "C X\t");
					}
				}
			}
			System.out.println("");
		}
	} // end printCurrentSeatStatus method
	/*
	 *  printPassengerList prints out the names of each passenger that is in the plane, along with their seat types.
	 *  
	 *  @param p : The 2D array that contains all of the seats. 
	 */
	public static void printPassengerList(Seat[][] p) {
		System.out.println("-------- Passenger List --------");
		
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				if (!(p[i][j].getAvailability())) {
					if (j == 0) {
						System.out.print((i + 1) + "A  Passenger Name: " + p[i][j].getPassengerName() + "\n    "
								+ "Seat Type: " + p[i][j].getSeatType() + "\n");
					}
					if (j == 1) {
						System.out.print((i + 1) + "B  Passenger Name: " + p[i][j].getPassengerName() + "\n    "
								+ "Seat Type: " + p[i][j].getSeatType() + "\n");
					}
					if (j == 2) {
						System.out.print((i + 1) + "C  Passenger Name: " + p[i][j].getPassengerName() + "\n    "
								+ "Seat Type: " + p[i][j].getSeatType() + "\n");
					}
				}
			}
		}
	} // end printPassengerList method
	/*
	 *  selectSeat iterates through the passed in array, using the row and seat letter that the user input.
	 *  First checks to see which column the user wants by checking the seat letter. 
	 *  Then uses the row variable that has been lowered by 1 in the beginning to choose the row, then checking
	 *  the availability of that seat.
	 *  
	 *  @param row : an int value that signifies which row the user is requesting
	 *  @param letter : the String value that represents the "column" the user requests.
	 *  @param passengerN : the name of the passenger reserving the seat. 
	 *  @param p : the 2D array of seats that the method iterates through.
	 *  @return : returns a boolean, true if seat was reserved, false if not.
	 */
	public static boolean selectSeat(int row, String letter, String passengerN, Seat[][] p) {
		row--;
		if (letter.equals("A")) {
			if (p[row][0].getAvailability()) {
				p[row][0].setAvailability(false);
				p[row][0].setPassengerName(passengerN);
				return true;
			}
		}
		else if (letter.equals("B")) {
			if (p[row][1].getAvailability()) {
				p[row][1].setAvailability(false);
				p[row][1].setPassengerName(passengerN);
				return true;	
			}
		}
		else if (letter.equals("C")) {
			if (p[row][2].getAvailability()) {
				p[row][2].setAvailability(false);
				p[row][2].setPassengerName(passengerN);
				return true;	
			}
		} 
		return false;
	} // end selectSeat method
	/*
	 * findPassenger iterates through the passed-in array, searching for the exact match of the name that the user
	 * inputted. 
	 * 
	 * @param p : the 2D array of seats
	 */
	public static void findPassenger(String name, Seat[][] p) {
		boolean found = false;
		for (int r = 0; r < p.length; r++) {
			for (int c = 0; c < p[r].length; c++) {
				if (p[r][c].getPassengerName().equals(name)) {
					String seatLetter = "";
					if (c == 0)
						seatLetter = "A";
					else if (c == 1)
						seatLetter = "B";
					else if (c == 2)
						seatLetter = "C";
					System.out.println("Passenger " + name + " found!");
					System.out.println("Seated in seat " + (r + 1) + seatLetter + ".\n");
					found = true;
					break;
				}
			}
			if (found) 
				break;
		}
		if (!found)
			System.out.println("Passenger \"" + name + "\" not found...\n");
	}// end findPassenger method

}