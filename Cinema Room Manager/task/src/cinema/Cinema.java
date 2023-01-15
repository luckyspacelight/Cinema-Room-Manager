package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int rows = readNumbers("\nEnter the number of rows:");
        int cols = readNumbers("Enter the number of seats in each row:");

        int action;
        boolean isActive = true;
        int rowNumber = 0;
        int seatNumber = 0;
        boolean isEmpty = true; //Array seats
        String [][] seats = new String[rows][cols];

        while (isActive) {
            action = viewMenu();
            switch (action) {
                case 1 -> isEmpty = printCinema(rows, cols, rowNumber, seatNumber, seats, isEmpty);
                case 2 -> {
                    rowNumber = readNumbers("\nEnter a row number:");
                    seatNumber = readNumbers("Enter a seat number in that row:");
                    determineTicketPrice(rows, cols, rowNumber);
                }
                case 0 -> isActive = false;
            }
        }
    }

    private static int viewMenu() {
        String menu = """
                \n1. Show the seats
                2. Buy a ticket
                0. Exit
                """;
        System.out.print(menu);
        return scanner.nextInt();
    }

    private static int readNumbers(String strMessage) {
        System.out.println(strMessage);
        return scanner.nextInt();
    }

    private static boolean printCinema
            (int rows, int cols,
             int sRow, int sSeat,
             String[][] seats, boolean isEmpty) {

        System.out.println("\nCinema:");

        // Fill the seats array if it is empty
        if (isEmpty) {
            for (String[] row : seats) {
                Arrays.fill(row, "S");
            }
            isEmpty = false;
        }

        //Print the header
        for (int i = 0; i <= cols; i++) {
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
                if (sRow == i + 1 && sSeat == j + 1) {
                    seats[i][j] = "B";
                }
                System.out.printf("%s ", seats[i][j]);
            }
            System.out.printf("%n");
        }
        return isEmpty;
    }

    private static void determineTicketPrice(int rowsNumber, int seatsPerRow, int rowNumber) {

        // Total seats
        int seatsTotalNumber = rowsNumber * seatsPerRow;

        // Determine the ticket price ($8 o $10)
        int ticketPrice = 10;
        if (seatsTotalNumber > 60 && rowNumber > rowsNumber / 2) {
            ticketPrice = 8;
        }

        // Print ticket price
        System.out.printf("%nTicket price: $%d%n", ticketPrice);
    }
}