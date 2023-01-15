import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        final int twenty = 20;
        boolean isTwenty = false;
        if (number1 + number2 == twenty
                || number2 + number3 == twenty
                || number1 + number3 == twenty) {
            isTwenty = true;
        }
        System.out.println(isTwenty);
    }
}
