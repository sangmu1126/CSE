package Lab06_2;

public class Lab06_2 {
    public static void main(String[] args) {
        Circle c1 = new Circle(3, 4, 5);
        Circle c2 = new Circle(3, 4, 5);
        Circle c3 = new Circle(3, 4, 6);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        if (c1.equals(c2)) {
            System.out.println("c1 == c2");
        }
        else {
            System.out.println("c1 != c2");
        }

        if (c1.equals(c3)) {
            System.out.println("c1 == c3");
        }
        else {
            System.out.println("c1 != c3");
        }
    }
}
