package cinema;

import java.util.Arrays;

public class Cinema {

    public static void main(String[] args) {

        System.out.println("Cinema:");

        int cols = 8;
        int rows = 7;

        /*
        int firstRow = 0;
        int firstCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == firstRow) {
                    if (j == 0) {
                        System.out.print("  ");
                    } else {
                        System.out.printf("%d ", j);
                    }
                } else {
                    if (j == firstCol) {
                        System.out.printf("%d ", i);
                    } else {
                        System.out.printf("S ");
                    }
                }
            }
            System.out.printf("%n");
        }
        */

        String[] header = {" ", "1", "2", "3", "4", "5", "6", "7", "8"};
        //Create a 2D Array
        String [][] seats = new String[rows][cols];

        // Fill the seats array
        for (String[] row : seats) {
            Arrays.fill(row, "S");
        }

        for (int i = 0; i < header.length; i++) {
            System.out.printf("%s ", header[i]);
        }
        System.out.print("\n");

        for (int i = 0; i < seats.length; i++) {
            System.out.printf("%d ", i + 1);  // Row numbers
            for (int j = 0; j < seats[i].length; j++) {
                System.out.printf("%s ", seats[i][j]);
            }
            System.out.printf("%n");
        }
    }
}