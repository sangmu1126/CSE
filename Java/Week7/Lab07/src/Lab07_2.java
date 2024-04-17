import java.util.ArrayList;
import java.util.Scanner;

public class Lab07_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLen = 0;
        int maxIdx = 0;
        ArrayList<String> arr = new ArrayList<>();

        System.out.print("? ");
        String s = scanner.next();
        while(!s.equals("exit")) {
            arr.add(s);
            System.out.print("? ");
            s = scanner.next();
        }

        for(int i=0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
            if (arr.get(i).length() > maxLen) {
                maxIdx = i;
            }
        }

        System.out.print("\nthe longest name: " + arr.get(maxIdx));
    }
}
