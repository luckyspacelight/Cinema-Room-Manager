import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int arLength = scan.nextInt();
        int[] thisIsAnArray = new int[arLength];

        int sum = 0;
        for (int i = 0; i < thisIsAnArray.length; i++) {
            if (scan.hasNext()) {
                thisIsAnArray[i] = scan.nextInt();
                sum += thisIsAnArray[i];
            }
        }
        System.out.println(sum);
    }
}