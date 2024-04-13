import java.util.Scanner;
import java.util.StringTokenizer;

public class Lab06_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a string: ");
        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer(s);

        int startIndex = 25;
        sb.delete(0, startIndex);
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");
        System.out.println("startIndex = " + startIndex + ", #words = " + st.countTokens());
        System.out.println(sb);

    }
}
