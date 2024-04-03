import java.util.InputMismatchException;
import java.util.Scanner;

public class Program5 {
    public static int[] makeArray(int k) {
        int[] arr = new int[k];
        return arr;
    }
    public static void main(String[] args) {
        System.out.println("Enter 8 integers");
        Scanner scanner = new Scanner(System.in);

        int[][] arr;
        arr = new int[3][];
        arr[0] = new int[3];
        arr[1] = new int[1];
        arr[2] = new int[4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextInt();
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
