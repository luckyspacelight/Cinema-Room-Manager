import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int h1 = scanner.nextInt();
        int h2 = scanner.nextInt();
        int h3 = scanner.nextInt();
        boolean isOrdered = checkHeight(h1, h2, h3);
        System.out.println(isOrdered);
    }

    private static boolean checkHeight(int h1, int h2, int h3) {
        return h1 >= h2 && h2 >= h3 || h1 <= h2 && h2 <= h3;
    }
}
