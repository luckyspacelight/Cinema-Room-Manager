import java.util.Scanner;

class Main {

    static final int THREE = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[THREE];
        boolean isDifferent = false;

        for (int i = 0; i < numbers.length; i++) {
            if (scanner.hasNext()){
                numbers[i] = scanner.nextInt();
            }
        }

        isDifferent = numbers[0] != numbers[1] && numbers[0] != numbers[2] && numbers[1] != numbers[2] ? true : false;
        System.out.println(isDifferent);
    }
}
