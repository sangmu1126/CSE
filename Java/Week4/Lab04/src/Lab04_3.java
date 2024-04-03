import java.util.Scanner;

class Student2 {
    private String name;
    private int birth;

    Student2(String name, int birth) {
        this.name = name;
        this.birth = birth;
    }

    public void printInfor() {
        System.out.println(this.name + " " + this.birth);
    }
}

public class Lab04_3 {
    static Scanner scan = new Scanner(System.in);
    static void closeScanner() {
        scan.close();
    }
    public static Student2[] makeArray(int num) {
        Student2[] s;
        s = new Student2[num];

        for(int i=0; i < s.length; i++) {
            System.out.print("Enter your name and birth: ");
            String name = scan.next();
            int birth = scan.nextInt();
            s[i] = new Student2(name, birth);
        }

        return s;
    }
    public static void printArray(Student2[] arr) {
        for(Student2 std : arr) {
            std.printInfor();
        }
    }
    public static void main(String[] args) {
        int number;
        System.out.print("Enter #students: ");
        number = scan.nextInt();
        Student2[] sArr = makeArray(number);
        System.out.println();
        printArray(sArr);
        Lab04_3.closeScanner();
    }
}
