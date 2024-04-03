import java.util.Scanner;
public class Program2 {
    public static void main(String[] args) {
        System.out.print("Input 5 positive numbers: ");
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int[] intArray = new int[5];

        for (int i=0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
            sum += intArray[i];
        }

        double avg = (double)sum/intArray.length;

        System.out.println("Average: " + avg);
    }
}
