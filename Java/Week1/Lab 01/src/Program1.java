import java.util.Scanner;
public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("age : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("name : ");
        String name = scanner.nextLine();

        System.out.print(age + " " + name);
    }
}