package Lab06_2;

import Lab06_2.Point;

public class Circle extends Point{
    private int r;

    Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }
    public boolean equals(Object obj) {
        Circle c = (Circle) obj;
        int res = c.toString().compareTo((obj.toString()));
        if(c.r == r && res == 0) return true;
        else return false;
    }
    public String toString() {
        return super.toString() + ", r = " + this.r;
    }
}
