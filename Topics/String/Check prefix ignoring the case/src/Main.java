import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        boolean isStartingWithJ = inputString.toLowerCase().startsWith("j");
        System.out.println(isStartingWithJ);
    }
}