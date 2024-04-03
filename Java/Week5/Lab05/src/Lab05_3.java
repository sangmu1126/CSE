import java.util.Scanner;

abstract class Stack {
    public abstract int length();
    public abstract int capacity();
    public abstract String pop();
    public abstract boolean push(String str);
}

class StringStack extends Stack {
    private String[] arr;
    private int tos = -1;

    StringStack(int size) {
        this.arr = new String[size];
    }

    @Override
    public int length() {
        return tos+1;
    }

    @Override
    public int capacity() {
        return this.arr.length;
    }

    @Override
    public String pop() {
        if (tos==-1) {
            return null;
        }
        return arr[tos--];
    }

    @Override
    public boolean push(String str) {
        if (this.length() == this.capacity()) {
            return false;
        }
        arr[++tos] = str;
        return true;
    }

}

public class Lab05_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("size of stack : ");
        int sz = scanner.nextInt();

        StringStack stack = new StringStack(sz);

        for(;;) {
            System.out.print("input: ");
            String str = scanner.next();

            if (str.equals("exit")) {
                System.out.print("pop all strings: ");
                while(stack.length()!=0) {
                    System.out.print(stack.pop() + " ");
                }
                break;
            }
            if (!stack.push(str)) {
                System.out.println("stack is full!");
            }
        }
    }
}
