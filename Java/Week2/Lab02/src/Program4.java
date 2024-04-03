import java.util.InputMismatchException;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 6 integers one by one.");

        int[][] arr;
        arr = new int[2][3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    arr[i][j] = scanner.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.println("Not an integer!");
                    scanner.nextLine();
                    j--;
                }
            }
        }

        System.out.println();
        for (int[] num : arr) {
            for (int elem : num) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
