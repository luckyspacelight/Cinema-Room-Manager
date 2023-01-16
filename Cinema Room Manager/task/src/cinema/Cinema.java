package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    static Scanner scanner = new Scanner(System.in);

    public static String[][] createTheCinemaTheatre() {

        int rows = readNumbers("\nEnter the number of rows:");
        int cols = readNumbers("Enter the number of seats in each row:");

        String[][] seats = new String[rows][cols];

        for (String[] row : seats) {
            Arrays.fill(row, "S");
        }
        return seats;
    }

    public static void main(String[] args) {

        boolean isActive = true;
        int action = -1;
        int purchasedTickets = 0;
        int currentIncome = 0;

        // *** CINEMA INITIALIZE
        // Create the seats in the room
        String[][] seats = createTheCinemaTheatre();
        // Determine total income
        int totalIncome = determineTotalIncome(seats.length, seats[0].length);
        // Determine total tickets
        int totalTickets = seats.length *  seats[0].length;

        while (isActive) {
            action = viewMenu();
            switch (action) {
                case 1 -> showTheSeats(seats);
                case 2 -> {
                    int tmpTicketPrice = buyATicket(seats);
                    if (tmpTicketPrice != 0) {
                        currentIncome += tmpTicketPrice;   // Update current Income
                        purchasedTickets++;                // Update purchased tickets
                    }
                }
                case 3 -> showStatistics(purchasedTickets, currentIncome, totalIncome, totalTickets);
                case 0 -> isActive = false;
            }
        }
    }

    private static int viewMenu() {
        String menu = """
                \n1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """;
        System.out.print(menu);
        return scanner.nextInt();
    }

    private static int readNumbers(String strMessage) {
        System.out.println(strMessage);
        return scanner.nextInt();
    }

    private static void showTheSeats(String[][] seats) {

        System.out.println("\nCinema:");

        //Print the header
        for (int i = 0; i <= seats[0].length; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.printf("%d ", i);
            }
        }
        System.out.print("\n");

        //Print the rest of the table
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("%d ", i + 1);  // Row numbers
            for (int j = 0; j < seats[i].length; j++) {
                System.out.printf("%s ", seats[i][j]);
            }
            System.out.printf("%n");
        }
    }

    private static int buyATicket(String[][] seats) {

        boolean isAlreadyPurchased = false;

        do {
            int rowNumber = readNumbers("\nEnter a row number:");
            int seatNumber = readNumbers("Enter a seat number in that row:");

            if(rowNumber > seats.length || seatNumber > seats[0].length) {
                System.out.println("\nWrong input!");
                return 0;
            }

            if (seats[rowNumber - 1][seatNumber - 1].equals("B")) {
                System.out.println("\nThat ticket has already been purchased!");
                isAlreadyPurchased = true;
            } else {
                seats[rowNumber - 1][seatNumber - 1] = "B";
                return determineTicketPrice(seats.length, seats[0].length, rowNumber);
            }

        } while (isAlreadyPurchased);

        return 0;
    }

    private static int determineTicketPrice(int rowsNumber, int seatsPerRow, int rowNumber) {

        // Total seats
        int seatsTotalNumber = rowsNumber * seatsPerRow;

        // Determine the ticket price ($8 o $10)
        int ticketPrice = 10;
        if (seatsTotalNumber > 60 && rowNumber > rowsNumber / 2) {
            ticketPrice = 8;
        }

        // Print ticket price
        System.out.printf("%nTicket price: $%d%n", ticketPrice);
        return ticketPrice;
    }

    private static int determineTotalIncome(int rowsNumber, int seatsPerRow) {

        int seatsTotalNumber = rowsNumber * seatsPerRow;

        int ticketPrice = 10;
        int backtHalfTicketPrice = 8;
        int TotalIncome = 0;
        int frontHalfSeats = 0;
        int backHalfSeats = 0;

        if (seatsTotalNumber <= 60) {
            TotalIncome = seatsTotalNumber * ticketPrice;
        } else if (seatsTotalNumber > 60) {
            frontHalfSeats = rowsNumber / 2 * seatsPerRow;
            backHalfSeats = (rowsNumber - (rowsNumber / 2)) * seatsPerRow;
            TotalIncome = frontHalfSeats * ticketPrice + backHalfSeats * backtHalfTicketPrice;
        }

        return TotalIncome;
    }

    private static void showStatistics(int purchasedTickets, int currentIncome, int totalIncome, int totalTickets) {

        float percentage = (float) purchasedTickets / totalTickets * 100;

        System.out.printf("%nNumber of purchased tickets: %d", purchasedTickets);
        System.out.printf("%nPercentage: %.2f%%", percentage);
        System.out.printf("%nCurrent income: $%d", currentIncome);
        System.out.printf("%nTotal income: $%d%n", totalIncome);

    }
}