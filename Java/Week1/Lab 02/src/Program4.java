import java.util.Scanner;

public class Program4 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Center of circle : ");
        int cenX = scanner.nextInt();
        int cenY = scanner.nextInt();

        System.out.print("Radius : ");
        double rad = scanner.nextDouble();

        System.out.print("Point : ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        String result;
//        double tan = Math.tan((double)x/y);
//        double cos = 1/(Math.sqrt(1+tan*tan));
//        double sin = Math.sqrt(1-cos*cos);
//
//        if (Math.abs(x-cenX) > Math.abs(rad * cos) || Math.abs(y-cenY) > Math.abs(rad * sin)) {
//            result = "not in the circle";
//        }
//        else {
//            result = "inside the circle";
//        }

        double dis = Math.sqrt(Math.pow(x-cenX, 2) + Math.pow(y-cenY,2 ));

        if (dis > rad) {
            result = "not in the circle";
        }
        else {
            result = "inside the circle";
        }

        System.out.println("(" + x + ", " + y + ") : " + result);
    }
}
