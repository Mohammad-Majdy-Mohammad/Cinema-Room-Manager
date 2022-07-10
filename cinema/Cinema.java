package cinema;

public class Cinema {

	
	private static int rows = 0;
	private static int columns = 0;
	private String[][] cinemaSeats;
	public static int purchasedTickets = 0; 
	public static int currentIncome = 0;
	
	public static void setColumns(int columns) {
		Cinema.columns = columns;
	}
	
	public static void setRows(int rows) {
		Cinema.rows = rows;
	}
	
	
	public Cinema (String[][] cinematSeats, int rows, int columns) {
		this.cinemaSeats = cinematSeats;
		this.rows = rows;
		this.columns = columns;
	}
	
	public void setCinemaSeats(String[][] cinemaSeats) {
		this.cinemaSeats = cinemaSeats;
	}
	
	
	
	public void showCinemaSeats() {
		
		System.out.println("Cinema:");
		
		for (int i = 0; i < cinemaSeats.length; ++i) {
			
			for (int j = 0; j < cinemaSeats[i].length; ++j) {
			
				System.out.print(cinemaSeats[i][j] + " ");
				
			}
			
			System.out.println();
		}	
	}
	
	
	
	protected void createCinemaTheater() {
		
		for (int i = 0; i < cinemaSeats.length; ++i) {
			
			for (int j = 0; j < cinemaSeats[i].length; ++j) {
				cinemaSeats[i][j] = (i > 0 && j > 0 ? "S" : i == 0 && j > 0 ? Integer.toString(j) : i > 0 && j == 0 ? Integer.toString(i) : " ");	
			}	
		}	
	}
	
	
	protected int calculateIncome (int seats, int rows) {
		
		return seats <= 60 ? 10 * seats : (rows / 2) * (seats / rows) * 10 + ((rows + 1) / 2) * (seats / rows) * 8;
		
	}
	
	
	protected boolean calculateTicketPrice(int totalSeats, int seats, int rows, int seatRow, int seatNumber) {
		
		if (seatRow > rows || seatNumber > seats) {
			System.out.println("Wrong input!");
			return false;
		}
		
		if (cinemaSeats[seatRow][seatNumber].equalsIgnoreCase("S")) {
			if (totalSeats > 60) {
				
				System.out.println("Ticket price: $" + ((rows / 2) >= seatRow ? 10 : 8));
				currentIncome +=  ((rows / 2) >= seatRow ? 10 : 8);
				++purchasedTickets;
				
			} else {
						
				System.out.println("Ticket price: $" + 10);
				currentIncome += 10;
				++purchasedTickets;
				
			}
			
			cinemaSeats[seatRow][seatNumber] = "B";
			return true;
			
		} else {
			
			System.out.println("That ticket has already been purchased!");
			return false;
		}
		
	}
	
}
