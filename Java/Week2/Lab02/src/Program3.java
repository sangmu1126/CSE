import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        System.out.println("Input your message.");
        System.out.println("q: quit the program.");

        Scanner scanner = new Scanner(System.in);

        for(;;) {
            String msg = scanner.nextLine();
            System.out.println(msg);

            if (msg.equals("q")) {
                break;
            }
        }
        System.out.println("\nBye!");
    }
}