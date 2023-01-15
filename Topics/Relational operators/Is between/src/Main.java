import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int arLength = 3;
        int[] ar3Integers = new int[arLength];

        for (int i = 0; i < arLength; i++) {
            ar3Integers[i] = scanner.nextInt();
        }

        int maxValue = Math.max(ar3Integers[1], ar3Integers[2]);
        int minValue = Math.min(ar3Integers[1], ar3Integers[2]);
        boolean isBetweenValues = isBetween(ar3Integers[0], maxValue, minValue);
        System.out.println(isBetweenValues);
    }

    private static boolean isBetween(int firstValue, int maxValue, int minValue) {
        return firstValue >= minValue && firstValue <= maxValue;
    }
}