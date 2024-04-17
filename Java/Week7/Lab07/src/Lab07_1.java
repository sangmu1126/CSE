import java.util.Vector;
import java.util.Iterator;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Lab07_1 {
    public static void main(String[] args) {
       Point p1 = new Point(5, 16);
       Point p2 = new Point(2, 12);
       Point p3 = new Point(11, 4);

        Vector<Point> p = new Vector<>();

       p.add(p1);
       p.add(p2);
       p.add(p3);

       Iterator<Point> it = p.iterator();

       while(it.hasNext()){
           Point pIt = it.next();
           System.out.println("(" + pIt.x + ", " + pIt.y + ")");
       }
    }
}