import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value
        int peanutButterCups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();
        boolean isSuccessful = false;

        final int minWeekendRange = 15;
        final int maxWeekendRange = 25;
        final int minWorkDaysRange = 10;
        final int maxWorkDaysRange = 20;

        boolean isSuccessfulWeekend = peanutButterCups >= minWeekendRange && peanutButterCups <= maxWeekendRange;
        boolean isSuccessfulWorkDays = peanutButterCups >= minWorkDaysRange && peanutButterCups <= maxWorkDaysRange;

        isSuccessful = isWeekend ? isSuccessfulWeekend : isSuccessfulWorkDays;
        System.out.println(isSuccessful);
    }
}
