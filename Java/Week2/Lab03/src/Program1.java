import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        System.out.println("Input 5 positive numbers.");
        Scanner scanner = new Scanner(System.in);

        int max = 0;
        int[] arr = new int[5];

        for (int i=0; i < 5; i++) {
            int num = scanner.nextInt();
            arr[i] = num;

            if (max < num) {
                max = num;
            }
        }
        System.out.println("Maximum number: "+ max);
    }
}
