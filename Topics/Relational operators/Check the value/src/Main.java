import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        final int nTen = 10;
        int number = scanner.nextInt();
        boolean isLessThan10 = number < nTen;
        System.out.println(isLessThan10);
    }
}
