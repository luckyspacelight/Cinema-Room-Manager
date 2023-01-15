import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
       
        // Create first (input) array
        int[][] inputArray = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                inputArray[i][j] = scanner.nextInt();
            }
        }

        // Create second (output) array
        int[][] outputArray = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                outputArray[j][rows - 1 - i] = inputArray[i][j];
            }
        }

        for (int[] nestedArray : outputArray) {
            for (int arElement : nestedArray) {
                System.out.printf("%d ", arElement);
            }
            System.out.println();
        }
    }
}