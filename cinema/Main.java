package cinema;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of rows:");
		int rows = scan.nextInt();
		System.out.println("Enter the number of seats in each row");
		int seats = scan.nextInt();
		
		// creating a cinema theater with the specified rows and seats
		String[][] theater = new String[rows + 1][seats + 1];
		Cinema cinema = new Cinema(theater, rows, seats);
		cinema.createCinemaTheater();
		
		
		boolean isRunning = true;

		while (isRunning) {
			
			System.out.println("1. Show the seats\n"
					+ "2. Buy a ticket\n"
					+ "3. Statistics\n"
					+ "0. Exit");
			
			boolean isNotValid = true;
			String choice = scan.next();
			if (choice.equals("1") || choice.equalsIgnoreCase("Show")) {
				
				cinema.showCinemaSeats();
				
			} else if (choice.equals("2") || choice.equalsIgnoreCase("Buy")) {
				
				while (isNotValid) {
					System.out.println("Enter a row number:");
					int rowNum = scan.nextInt();
					System.out.println("Enter a seat number in that row:");
					int seatNum = scan.nextInt();
					isNotValid = !cinema.calculateTicketPrice(seats * rows, seats, rows, rowNum, seatNum);
				}
				
			} else if (choice.equals("0") || choice.equalsIgnoreCase("Exit")) {
				
				isRunning = false;
				 
			} else if (choice.equals("3") || choice.equalsIgnoreCase("Statistics")){
				
				System.out.printf("Number of purchased tickets %d\n", Cinema.purchasedTickets);
				System.out.printf("Percentage: %.2f%c\n", 100 * Cinema.purchasedTickets / (rows * seats * 1.0), '%');
				System.out.printf("Current income: $%d\n", Cinema.currentIncome);
				System.out.printf("Total income: $%d\n", cinema.calculateIncome(seats * rows, rows));
				
			} else {
				
				System.out.println("Wrong input!");
				
				while (isNotValid) {
					System.out.println("Enter a row number:");
					int rowNum = scan.nextInt();
					System.out.println("Enter a seat number in that row:");
					int seatNum = scan.nextInt();
					isNotValid = !cinema.calculateTicketPrice(seats * rows, seats, rows, rowNum, seatNum);
					
				}
				
			}
			
		}
	}

}
